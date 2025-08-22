package com.moby.digital.gestorturnosmedicos.service;

import com.moby.digital.gestorturnosmedicos.entity.ProfesionalEntity;
import com.moby.digital.gestorturnosmedicos.model.Profesional;
import com.moby.digital.gestorturnosmedicos.model.mapper.ProfesionalMapper;
import com.moby.digital.gestorturnosmedicos.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalService {
    private final ProfesionalRepository profesionalRepository;
    private final ProfesionalMapper mapper;

    @Autowired
    public ProfesionalService(ProfesionalRepository profesionalRepository) {
        this.mapper = new ProfesionalMapper();
        this.profesionalRepository = profesionalRepository;
    }

    public Profesional crearProfesional(Profesional profesional) {
        ProfesionalEntity pro = mapper.toEntity(profesional);
        return mapper.toModel(profesionalRepository.save(pro));
    }

    public List<Profesional> listarProfesional(String especialidad) {
        return mapper.toModelList(profesionalRepository.findByEspecialidadIgnoreCase(especialidad));
    }
}
