package com.moby.digital.gestorturnosmedicos.service;
import java.time.LocalDate;
import java.util.List;
import com.moby.digital.gestorturnosmedicos.model.Turno;
import com.moby.digital.gestorturnosmedicos.model.mapper.TurnoMapper;
import com.moby.digital.gestorturnosmedicos.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper mapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
        this.mapper = new TurnoMapper();
    }


    public List<Turno> findAll(){
        return mapper.toModelList(turnoRepository.findAll());
    }

    public List<Turno> findByFecha(LocalDate fecha){
        return mapper.toModelList(turnoRepository.findByFecha(fecha));
    }

    public Turno create(Turno turno){
        return mapper.toModel(turnoRepository.save(mapper.toEntity(turno)));
    }

    public void delete(Long id){
        turnoRepository.deleteById(id);
    }



}

