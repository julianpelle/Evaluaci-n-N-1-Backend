package com.moby.digital.gestorturnosmedicos.repository;

import com.moby.digital.gestorturnosmedicos.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {

    List<TurnoEntity> findByFecha(LocalDate fecha);

}
