package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Profesional;
import com.moby.digital.gestorturnosmedicos.service.ProfesionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {
    private final ProfesionalService profesionalService;

    @Autowired
    public ProfesionalController(ProfesionalService profesionalService) {
        this.profesionalService = profesionalService;
    }

    @Operation(summary = "Listar profesionales por especialidad")
    @ApiResponse(responseCode = "200", description = "Listado obtenido")
    @GetMapping(params = "especialidad")
    public List<Profesional> getProfesionalByEspecialidad(@RequestParam("especialidad") String especialidad) {
        return profesionalService.listarProfesional(especialidad);
    }

    @Operation(summary = "Crear profesional")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Profesional creado"),
            @ApiResponse(responseCode = "400", description = "Error de validacion")
    })
    @PostMapping
    public Profesional createProfesional(@RequestBody Profesional profesional) {
        return profesionalService.crearProfesional(profesional);
    }

}
