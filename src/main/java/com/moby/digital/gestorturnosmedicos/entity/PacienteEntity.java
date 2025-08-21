package com.moby.digital.gestorturnosmedicos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pacientes")
@Getter@Setter
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    @NotBlank(message = "El Nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 7, max = 8, message = "El DNI debe tener entre 7 y 8 dígitos")
    private String dni;

    @Column(unique = true)
    @NotBlank(message = "El email no debe estar vacio")
    @Email(message = "El formato del email no es válido")
    private String email;

    @OneToMany(mappedBy = "paciente")
    private List<TurnoEntity> turnos;

    public PacienteEntity(Long id, String nombre, String apellido, String dni, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }

    public PacienteEntity() {}
}
