package com.moby.digital.gestorturnosmedicos.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String dni, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }

    public Paciente id(Long id) {
        this.id = id;
        return this;
    }

    public Paciente nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Paciente apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Paciente dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Paciente email(String email) {
        this.email = email;
        return this;
    }

}
