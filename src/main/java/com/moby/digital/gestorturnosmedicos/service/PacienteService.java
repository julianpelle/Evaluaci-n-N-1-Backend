package com.moby.digital.gestorturnosmedicos.service;

import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.exception.RecursoNoEncontradoException;
import com.moby.digital.gestorturnosmedicos.model.Paciente;
import com.moby.digital.gestorturnosmedicos.model.mapper.PacienteMapper;
import com.moby.digital.gestorturnosmedicos.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper mapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = new PacienteMapper();
    }


    public List<Paciente> findAll() {
        List<PacienteEntity> ListaEntidadPaciente = pacienteRepository.findAll();
        return mapper.toModelList(ListaEntidadPaciente);
    }

    public Paciente findById(Long id) {
        return pacienteRepository.findById(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new RecursoNoEncontradoException("Paciente no encontrado: " + id));
    }

    public Paciente createPaciente(Paciente paciente) {
        PacienteEntity p = mapper.toEntity(paciente);
        return mapper.toModel(pacienteRepository.save(p));
    }

    public void eliminar(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Paciente no encontrado");
        }
        pacienteRepository.deleteById(id);
    }

}
