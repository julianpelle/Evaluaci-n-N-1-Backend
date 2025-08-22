package com.moby.digital.gestorturnosmedicos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profesionales")
@Getter
@Setter
public class ProfesionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El Nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotBlank(message = "La especialidad no puede estar vacia")
    private String especialidad;

    @OneToMany(mappedBy = "profesional")
    private List<TurnoEntity> turnos;

    public ProfesionalEntity() {
    }
}
