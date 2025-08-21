package com.moby.digital.gestorturnosmedicos.service;

import com.moby.digital.gestorturnosmedicos.model.Profesional;
import com.moby.digital.gestorturnosmedicos.model.mapper.ProfesionalMapper;
import com.moby.digital.gestorturnosmedicos.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalService {
    private ProfesionalRepository profesionalRepository;
    private ProfesionalMapper mapper;

    @Autowired
    public ProfesionalService(ProfesionalRepository profesionalRepository){
        this.mapper = new ProfesionalMapper();
        this.profesionalRepository = profesionalRepository;
    }


    public Profesional crearProfesional(Profesional profesional){
        return mapper.toModel(profesionalRepository.save(mapper.toEntity(profesional)));
    }

    public List<Profesional> listarProfesional(String especialidad){
        return mapper.toModelList(profesionalRepository.findByEspecialidadIgnoreCase(especialidad));
    }
}
