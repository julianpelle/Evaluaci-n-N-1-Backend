package com.moby.digital.gestorturnosmedicos.dto;

import com.moby.digital.gestorturnosmedicos.model.Paciente;
import com.moby.digital.gestorturnosmedicos.model.Profesional;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "Payload para la creación de un Turno")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TurnoDTO {

    @Schema(description = "Identificador del turno", example = "42")
    private Long id;

    @Schema(description = "Paciente del turno",
            implementation = PacienteDTO.class)
    @NotNull
    private PacienteDTO paciente;

    @Schema(description = "Profesional que atiende el turno",
            implementation = ProfesionalDTO.class)
    @NotNull
    private ProfesionalDTO profesional;

    @Schema(description = "Fecha del turno (formato YYYY-MM-DD)",
            example = "2025-08-21", type = "string", format = "date")
    @NotNull
    private LocalDate fecha;

}
