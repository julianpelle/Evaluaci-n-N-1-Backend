package com.moby.digital.gestorturnosmedicos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Payload para la creacion de un Profesional")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProfesionalDTO {
    @Schema(description = "Identificador del profesional", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private Long id;

    @Schema(
            description = "Nombre del profesional",
            example = "Juan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El Nombre no puede estar vacio")
    private String nombre;

    @Schema(
            description = "Apellido del profesional",
            example = "Doe",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Schema(
            description = "Especialidad del profesional",
            example = "Cardiologo",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "La especialidad no puede estar vacio")
    private String especialidad;

}
