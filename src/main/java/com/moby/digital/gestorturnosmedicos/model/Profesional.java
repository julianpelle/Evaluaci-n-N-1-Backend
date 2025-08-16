package com.moby.digital.gestorturnosmedicos.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@EqualsAndHashCode
public class Profesional {
    private Long id;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Profesional() {
    }

    public Profesional(Long id, String nombre, String apellido, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public Profesional IdProfesional(Long id) {
        this.id = id;
        return this;
    }
    public Profesional NombreProfesional(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public Profesional ApellidoProfesional(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public Profesional EspecialidadProfesional(String especialidad) {
        this.especialidad = especialidad;
        return this;
    }


}
