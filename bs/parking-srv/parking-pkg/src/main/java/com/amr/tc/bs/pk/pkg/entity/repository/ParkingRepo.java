package com.amr.tc.bs.pk.pkg.entity.repository;

import com.amr.tc.bs.pk.pkg.entity.ParkingJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParkingRepo extends JpaRepository<ParkingJpaEnt, UUID> {

    List<ParkingJpaEnt> findByParkedIdIn(List<UUID> parkedId);

}
