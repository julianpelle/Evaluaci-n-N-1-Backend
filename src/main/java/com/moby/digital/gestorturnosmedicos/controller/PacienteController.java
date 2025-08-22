package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Paciente;
import com.moby.digital.gestorturnosmedicos.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Listar todos los pacientes")
    @ApiResponse(responseCode = "200", description = "Listado obtenido")
    @GetMapping
    public List<Paciente> ObtenerPacientes() {
        return pacienteService.findAll();
    }

    @Operation(summary = "Obtener paciente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paciente obtenido"),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado")
    })
    @GetMapping("/{id}")
    public Paciente ObtenerPaciente(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @Operation(summary = "Crear paciente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Paciente creado"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @PostMapping
    public Paciente CrearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    @Operation(summary = "Eliminar paciente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Paciente eliminado"),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado")
    })
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }
}
