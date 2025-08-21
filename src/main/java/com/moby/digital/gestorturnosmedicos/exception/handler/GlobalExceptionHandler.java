package com.moby.digital.gestorturnosmedicos.exception.handler;

import com.moby.digital.gestorturnosmedicos.exception.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(RecursoNoEncontradoException.class)
    @ApiResponse(
            responseCode = "404",
            description = "Recurso no encontrado",
            content = @Content(
                    schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "El recurso necesario no ha podido ser encontrado")
            )
    )
    public ResponseEntity<String> handleNoEncontrado(RecursoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PacienteNoEncontradoException.class)
    @ApiResponse(
            responseCode = "404",
            description = "Recurso no encontrado",
            content = @Content(
                    schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "Paciente con id 1 no existe")
            )
    )
    public ResponseEntity<String> handlePacienteNoEncontrado(PacienteNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(ProfesionalNoEncontradoException.class)
    @ApiResponse(
            responseCode = "404",
            description = "Recurso no encontrado",
            content = @Content(
                    schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "Profesional con id 1 no existe")
            )
    )
    public ResponseEntity<String> handleProfesionalNoEncontrado(ProfesionalNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(TurnoDuplicadoException.class)
    @ApiResponse(
            responseCode = "409",
            description = "Conflicto: turno duplicado",
            content = @Content(
                    schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "Ya existe un turno identico a este")
            )
    )
    public ResponseEntity<String> handleTurnoDuplicado(TurnoDuplicadoException ex) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    // 409 Conflict
    // Esta respuesta puede ser enviada cuando una petición tiene conflicto con el estado actual del servidor.



    @ExceptionHandler(FechaInvalidaException.class)
    @ApiResponse(
            responseCode = "400",
            description = "Error de validación: fecha invalida",
            content = @Content(
                    schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "La fecha del turno debe ser hoy o posterior")
            )
    )
    public ResponseEntity<String> handleFechaInvalida(FechaInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}