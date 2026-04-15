package Guia2.repository;

import org.springframework.stereotype.Repository;
import Guia2.model.dto.responsedto.UserResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IRepository<UserResponseDTO> {

    private final List<UserResponseDTO> users = new ArrayList<>();
    private Long idCounter = 1L;

    public UserRepository() {
        users.add(new UserResponseDTO(1L, "Juan Perez", "juan@mail.com"));
        users.add(new UserResponseDTO(2L, "Maria Lopez", "maria@mail.com"));
        users.add(new UserResponseDTO(3L, "Carlos Gomez", "carlos@mail.com"));
        idCounter = 4L;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return users;
    }

    @Override
    public UserResponseDTO save(UserResponseDTO entity) {
        entity.setId(idCounter++);
        users.add(entity);
        return entity;
    }

    @Override
    public boolean delete(UserResponseDTO entity) {
        return users.removeIf(u -> u.getId().equals(entity.getId()));
    }

    @Override
    public Optional<UserResponseDTO> update(UserResponseDTO entity) {
        return users.stream()
                .filter(u -> u.getId().equals(entity.getId()))
                .findFirst()
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setEmail(entity.getEmail());
                    return existing;
                });
    }

    public Optional<UserResponseDTO> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}
