package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Turno;
import com.moby.digital.gestorturnosmedicos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;

    @Autowired
    public TurnoController(final TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<Turno> getAll(
            @RequestParam(required = false) LocalDate desde,
            @RequestParam(required = false) LocalDate hasta) {

        if (desde != null && hasta != null) {
            return turnoService.listarPorFechas(desde, hasta);
        } else {
            return turnoService.findAll();
        }
    }

    @GetMapping("/fecha/{fecha}")
    public List<Turno> getByDate(@PathVariable final LocalDate fecha) {
        return this.turnoService.findByFecha(fecha);
    }

    @PostMapping
    public Turno save(@RequestBody final Turno turno) {
        return this.turnoService.create(turno);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        this.turnoService.delete(id);
    }

}
