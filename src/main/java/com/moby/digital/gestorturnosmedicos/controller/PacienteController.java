package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Paciente;
import com.moby.digital.gestorturnosmedicos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> ObtenerPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente ObtenerPaciente(@PathVariable Long id) {
        return pacienteService.findById(id);
    }
    @PostMapping
    public Paciente CrearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }
}
