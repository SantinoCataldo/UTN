package Guia2.mapper;

import Guia2.model.dto.requestdto.UserCreateRequestDTO;
import Guia2.model.dto.responsedto.UserResponseDTO;
import Guia2.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserCreateRequestDTO dto);

    UserResponseDTO toResponseDTO(UserEntity entity);
}

