package com.moby.digital.gestorturnosmedicos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_turno_paciente"))
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesional_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_turno_profesional"))
    private ProfesionalEntity profesional;

    @Column(nullable = false)
    private LocalDate fecha;

    public TurnoEntity() {
    }
}
