package com.moby.digital.gestorturnosmedicos.repository;

import com.moby.digital.gestorturnosmedicos.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
