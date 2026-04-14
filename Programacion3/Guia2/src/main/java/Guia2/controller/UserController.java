package Guia2.controller;

import Guia2.model.dto.requestdto.UserCreateRequestDTO;
import Guia2.model.dto.responsedto.UserResponseDTO;
import Guia2.mapper.UserMapper;
import Guia2.model.UserEntity;
import Guia2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> response = service.getAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toResponseDTO(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserCreateRequestDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(service.create(user)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserCreateRequestDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        return ResponseEntity.ok(mapper.toResponseDTO(service.update(id, user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
