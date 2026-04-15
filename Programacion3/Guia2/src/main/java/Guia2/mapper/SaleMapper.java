package Guia2.mapper;

import Guia2.model.dto.requestdto.SaleCreateRequestDTO;
import Guia2.model.dto.responsedto.SaleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    SaleResponseDTO toResponseDTO(SaleCreateRequestDTO dto);

}
