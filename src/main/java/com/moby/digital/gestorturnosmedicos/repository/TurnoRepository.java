package com.moby.digital.gestorturnosmedicos.repository;

import com.moby.digital.gestorturnosmedicos.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {
}
