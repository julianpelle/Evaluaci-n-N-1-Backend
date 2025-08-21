package com.moby.digital.gestorturnosmedicos.initializer;

import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import com.moby.digital.gestorturnosmedicos.entity.ProfesionalEntity;
import com.moby.digital.gestorturnosmedicos.entity.TurnoEntity;
import com.moby.digital.gestorturnosmedicos.repository.PacienteRepository;
import com.moby.digital.gestorturnosmedicos.repository.ProfesionalRepository;
import com.moby.digital.gestorturnosmedicos.repository.TurnoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestCargaInicial {

    private final PacienteRepository pacienteRepository;
    private final ProfesionalRepository profesionalRepository;
    private final TurnoRepository turnoRepository;

    public TestCargaInicial(PacienteRepository pacienteRepository,
                           ProfesionalRepository profesionalRepository,
                           TurnoRepository turnoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.profesionalRepository = profesionalRepository;
        this.turnoRepository = turnoRepository;
    }

    @PostConstruct
    public void init() {
        // Pacientes
        PacienteEntity pac1 = new PacienteEntity();

        pac1.setNombre("Juan");
        pac1.setApellido("Pérez");
        pac1.setDni("30123456");
        pac1.setEmail("juan.perez@example.com");
        pacienteRepository.save(pac1);

        PacienteEntity pac2 = new PacienteEntity();

        pac2.setNombre("María");
        pac2.setApellido("Gómez");
        pac2.setDni("32123456");
        pac2.setEmail("maria.gomez@example.com");
        pacienteRepository.save(pac2);

        // Profesionales
        ProfesionalEntity profClinica = new ProfesionalEntity();

        profClinica.setNombre("Ana");
        profClinica.setApellido("López");
        profClinica.setEspecialidad("Clínica");
        profesionalRepository.save(profClinica);

        ProfesionalEntity profOdonto = new ProfesionalEntity();

        profOdonto.setNombre("Carlos");
        profOdonto.setApellido("Molina");
        profOdonto.setEspecialidad("Odontología");
        profesionalRepository.save(profOdonto);

        // Turnos (3 mínimos)
        LocalDate d1 = LocalDate.now().plusDays(1);
        LocalDate d2 = LocalDate.now().plusDays(2);

        TurnoEntity t1 = new TurnoEntity();

        t1.setPaciente(pac1);
        t1.setProfesional(profClinica);
        t1.setFecha(d1);
        turnoRepository.save(t1);

        TurnoEntity t2 = new TurnoEntity();

        t2.setPaciente(pac1);
        t2.setProfesional(profOdonto);
        t2.setFecha(d2);
        turnoRepository.save(t2);

        TurnoEntity t3 = new TurnoEntity();

        t3.setPaciente(pac2);
        t3.setProfesional(profClinica);
        t3.setFecha(d1);
        turnoRepository.save(t3);
    }
}