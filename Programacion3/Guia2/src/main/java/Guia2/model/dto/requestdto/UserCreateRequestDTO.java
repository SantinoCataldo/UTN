package Guia2.model.dto.requestdto;

import Guia2.validate.group.OnCreate;
import Guia2.validate.group.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotBlank(message = "El email no puede estar vacío", groups = {OnCreate.class, OnUpdate.class})
    @Email(message = "Debe ser un email válido", groups = {OnCreate.class, OnUpdate.class})
    private String email;
}
