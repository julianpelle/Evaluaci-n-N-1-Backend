package com.moby.digital.gestorturnosmedicos.repository;

import com.moby.digital.gestorturnosmedicos.entity.ProfesionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesionalRepository extends JpaRepository<ProfesionalEntity, Long> {

    List<ProfesionalEntity> findByEspecialidadIgnoreCase(String especialidad);

}
