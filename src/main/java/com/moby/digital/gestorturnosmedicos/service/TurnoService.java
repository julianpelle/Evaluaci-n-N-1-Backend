package com.moby.digital.gestorturnosmedicos.service;

import java.time.LocalDate;
import java.util.List;

import com.moby.digital.gestorturnosmedicos.entity.TurnoEntity;
import com.moby.digital.gestorturnosmedicos.exception.FechaInvalidaException;
import com.moby.digital.gestorturnosmedicos.exception.PacienteNoEncontradoException;
import com.moby.digital.gestorturnosmedicos.exception.ProfesionalNoEncontradoException;
import com.moby.digital.gestorturnosmedicos.exception.TurnoDuplicadoException;
import com.moby.digital.gestorturnosmedicos.model.Turno;
import com.moby.digital.gestorturnosmedicos.model.mapper.TurnoMapper;
import com.moby.digital.gestorturnosmedicos.repository.PacienteRepository;
import com.moby.digital.gestorturnosmedicos.repository.ProfesionalRepository;
import com.moby.digital.gestorturnosmedicos.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ProfesionalRepository profesionalRepository;
    private final PacienteRepository pacienteRepository;
    private final TurnoMapper mapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, PacienteRepository pacienteRepository, ProfesionalRepository profesionalRepository) {
        this.turnoRepository = turnoRepository;
        this.pacienteRepository = pacienteRepository;
        this.profesionalRepository = profesionalRepository;
        this.mapper = new TurnoMapper();
    }


    public List<Turno> findAll() {
        return mapper.toModelList(turnoRepository.findAll());
    }

    public List<Turno> findByFecha(LocalDate fecha) {
        return mapper.toModelList(turnoRepository.findByFecha(fecha));
    }

    public Turno create(Turno turno) {
        if (!pacienteRepository.existsById(turno.getPaciente().getId())) {
            throw new PacienteNoEncontradoException("No se encuentra el paciente con el id: " +
                    turno.getPaciente().getId() + " en nuestra base de datos");
        }
        if (!profesionalRepository.existsById(turno.getProfesional().getId())) {
            throw new ProfesionalNoEncontradoException("No se encuentra el profesional con el id: " +
                    turno.getProfesional().getId() + " en nuestra base de datos");
        }

        if (turnoRepository.existsByPacienteIdAndProfesionalIdAndFecha(turno.getPaciente().getId(), turno.getProfesional().getId(), turno.getFecha())) {
            throw new TurnoDuplicadoException("Ya existe un turno asignado para este paciente, con este mismo profesional para la misma fecha");
        }

        LocalDate hoy = LocalDate.now();
        if (turno.getFecha().isBefore(hoy)) {
            throw new FechaInvalidaException("No se pueden crear turnos en fechas pasadas");
        }

        // Este condicional lo cree para sumar una excepcion de más y me surgió la duda
        // de si está bien la manera de anidar las excepciones, llenado de if, o si hay algo
        // más general para lanzarlas, si me pongo a chequear todas las posibilidades capaz lo tengo lleno de Ifs solo para lanzar
        // excepciones, que creo que no seria lo ideal

        TurnoEntity t = mapper.toEntity(turno);
        t.setPaciente(pacienteRepository.getReferenceById(turno.getPaciente().getId()));
        t.setProfesional(profesionalRepository.getReferenceById(turno.getProfesional().getId()));
        return mapper.toModel(turnoRepository.save(t));

    }

    public void delete(Long id) {
        turnoRepository.deleteById(id);
    }

    public List<Turno> listarPorFechas(LocalDate desde, LocalDate hasta) {
        return mapper.toModelList(turnoRepository.findByFechaBetween(desde, hasta));
    }

}

