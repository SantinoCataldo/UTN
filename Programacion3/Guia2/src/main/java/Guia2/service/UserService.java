package Guia2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Guia2.model.dto.responsedto.UserResponseDTO;
import Guia2.model.dto.requestdto.UserCreateRequestDTO;
import Guia2.repository.UserRepository;
import Guia2.mapper.UserMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserResponseDTO> getAll() {
        return repository.findAll();
    }

    public UserResponseDTO getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    public UserResponseDTO create(UserCreateRequestDTO userDto) {
        UserResponseDTO toSave = mapper.toResponseDTO(userDto);
        return repository.save(toSave);
    }

    public UserResponseDTO update(Long id, UserCreateRequestDTO userDto) {

        UserResponseDTO existing = getById(id);

        existing.setName(userDto.getName());
        existing.setEmail(userDto.getEmail());

        return repository.update(existing)
                .orElseThrow(() -> new RuntimeException("Error al actualizar"));
    }

    public void delete(Long id) {

        UserResponseDTO existing = getById(id);

        if (!repository.delete(existing)) {
            throw new RuntimeException("No se pudo eliminar");
        }
    }
}
