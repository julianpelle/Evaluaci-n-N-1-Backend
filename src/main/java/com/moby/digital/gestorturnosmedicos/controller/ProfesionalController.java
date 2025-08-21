package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Profesional;
import com.moby.digital.gestorturnosmedicos.service.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {
    private ProfesionalService profesionalService;

    @Autowired
    public ProfesionalController(ProfesionalService profesionalService) {
        this.profesionalService = profesionalService;
    }

    @GetMapping(params = "especialidad")
    public List<Profesional> getProfesionalByEspecialidad(@RequestParam("especialidad") String especialidad) {
        return profesionalService.listarProfesional(especialidad);
    }

    @PostMapping
    public Profesional createProfesional(@RequestBody Profesional profesional) {
        return profesionalService.crearProfesional(profesional);
    }

}
