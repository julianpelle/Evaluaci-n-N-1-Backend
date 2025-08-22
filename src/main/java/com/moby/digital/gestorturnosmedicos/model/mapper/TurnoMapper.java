package com.moby.digital.gestorturnosmedicos.model.mapper;

import com.moby.digital.gestorturnosmedicos.dto.PacienteDTO;
import com.moby.digital.gestorturnosmedicos.dto.ProfesionalDTO;
import com.moby.digital.gestorturnosmedicos.dto.TurnoDTO;
import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.entity.ProfesionalEntity;
import com.moby.digital.gestorturnosmedicos.entity.TurnoEntity;
import com.moby.digital.gestorturnosmedicos.model.Turno;

import java.util.List;


public class TurnoMapper {

    private final PacienteMapper pacienteMapper = new PacienteMapper();
    private final ProfesionalMapper profesionalMapper = new ProfesionalMapper();


    public Turno toModel(TurnoDTO dto) {
        PacienteDTO p = dto.getPaciente();
        ProfesionalDTO prof = dto.getProfesional();
        Turno t = new Turno();
        t.setId(dto.getId());
        t.setPaciente(pacienteMapper.toModel(p));
        t.setProfesional(profesionalMapper.toModel(prof));
        t.setFecha(dto.getFecha());
        return t;
    }

    public Turno toModel(TurnoEntity turnoEntity) {
        PacienteEntity p = turnoEntity.getPaciente();
        ProfesionalEntity prof = turnoEntity.getProfesional();
        Turno t = new Turno();
        t.setId(turnoEntity.getId());
        t.setFecha(turnoEntity.getFecha());
        t.setPaciente(pacienteMapper.toModel(p));
        t.setProfesional(profesionalMapper.toModel(prof));
        return t;
    }

    public TurnoEntity toEntity(Turno turno) {
        TurnoEntity turnoEntity = new TurnoEntity();
        turnoEntity.setFecha(turno.getFecha());
        return turnoEntity;
    }

    public List<Turno> toModelList(List<TurnoEntity> turnoEntity) {
        return turnoEntity.stream().map(this::toModel).toList();
    }


}
