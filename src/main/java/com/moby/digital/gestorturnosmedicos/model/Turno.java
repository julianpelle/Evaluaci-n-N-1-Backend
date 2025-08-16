package com.moby.digital.gestorturnosmedicos.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter@EqualsAndHashCode
public class Turno {
    private Long id;
    private Paciente paciente;
    private Profesional profesional;
    private LocalDate fecha;

    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Profesional profesional, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.profesional = profesional;
        this.fecha = fecha;
    }

    public Turno turnoId(Long id) {
        this.setId(id);
        return this;
    }
    public Turno paciente(Paciente paciente) {
        this.setPaciente(paciente);
        return this;
    }
    public Turno professional(Profesional profesional) {
        this.setProfesional(profesional);
        return this;
    }
    public Turno fecha(LocalDate fecha) {
        this.setFecha(fecha);
        return this;
    }


}
