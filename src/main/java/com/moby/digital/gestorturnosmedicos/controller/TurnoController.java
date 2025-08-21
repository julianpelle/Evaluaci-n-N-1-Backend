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
    /*
● POST /turnos → Registrar turno (verifica que paciente y profesional
            existan)
● GET /turnos → Listar todos
● GET /turnos/fecha/{fecha} → Listar turnos por fecha (formato
                                                               yyyy-MM-dd)
● DELETE /turnos/{id} → Eliminar turn*/
    @GetMapping
    public List<Turno> getAll() {
        return this.turnoService.findAll();
    }

    @GetMapping("/fecha/{date}")
    public List<Turno> getByDate(@PathVariable final LocalDate date) {
        return this.turnoService.findByDate(date);
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
