package com.amr.tc.bs.car.carifr.pers.jpa.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarJpaRepo extends JpaRepository<CarJpaEnt, UUID> {

}
