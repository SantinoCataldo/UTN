package Guia2.controller;

import Guia2.model.dto.requestdto.UserCreateRequestDTO;
import Guia2.model.dto.responsedto.UserResponseDTO;
import Guia2.service.UserService;
import Guia2.validate.group.OnCreate;
import Guia2.validate.group.OnUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Validated(OnCreate.class) @RequestBody UserCreateRequestDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody UserCreateRequestDTO userDTO) {
        return ResponseEntity.ok(service.update(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
