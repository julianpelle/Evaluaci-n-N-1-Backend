
package com.moby.digital.gestorturnosmedicos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Payload para la creacion de un Paciente")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PacienteDTO {
    @Schema(description = "Identificador del paciente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private Long id;

    @Schema(
            description = "Nombre del paciente",
            example = "Juan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El Nombre no puede estar vacio")
    private String nombre;

    @Schema(
            description = "Apellido del paciente",
            example = "Perez",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Schema(
            description = "Documento Nacional de Identidad",
            example = "34567890",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 7, max = 8, message = "El DNI debe tener entre 7 y 8 dígitos")
    private String dni;

    @Schema(
            description = "Correo electronico del paciente",
            example = "juan.perez@mail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El email no debe estar vacio")
    @Email(message = "El formato del email no es valido")
    private String email;


}
