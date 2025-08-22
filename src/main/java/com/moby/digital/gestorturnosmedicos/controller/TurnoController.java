package com.moby.digital.gestorturnosmedicos.controller;

import com.moby.digital.gestorturnosmedicos.model.Turno;
import com.moby.digital.gestorturnosmedicos.service.TurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar turnos. Opcionalmente por rango de fechas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido"),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos")
    })
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

    @Operation(summary = "Listar turnos por fecha")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido"),
            @ApiResponse(responseCode = "400", description = "Formato de fecha invalido")
    })
    @GetMapping("/fecha/{fecha}")
    public List<Turno> getByDate(@PathVariable final LocalDate fecha) {
        return this.turnoService.findByFecha(fecha);
    }

    @Operation(summary = "Registrar turno")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Turno registrado"),
            @ApiResponse(responseCode = "400", description = "Fecha invalida o datos incompletos"),
            @ApiResponse(responseCode = "404", description = "Paciente o profesional no encontrado"),
            @ApiResponse(responseCode = "409", description = "Conflicto: turno duplicado")
    })
    @PostMapping
    public Turno save(@RequestBody final Turno turno) {
        return this.turnoService.create(turno);
    }

    @Operation(summary = "Eliminar turno por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Turno eliminado"),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado")
    })
    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        this.turnoService.delete(id);
    }

}
