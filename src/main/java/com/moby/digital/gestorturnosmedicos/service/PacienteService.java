package com.moby.digital.gestorturnosmedicos.service;

import com.moby.digital.gestorturnosmedicos.model.Paciente;
import com.moby.digital.gestorturnosmedicos.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

/*
● POST /pacientes → Crear paciente
● GET /pacientes/{id} → Obtener paciente por ID
● GET /pacientes → Listar todos
● DELETE /pacientes/{id} → Eliminar paciente

 */

    public List<Paciente> findAll() {
        return pacienteRepository.findAll().stream().map(this::)
    }


}
