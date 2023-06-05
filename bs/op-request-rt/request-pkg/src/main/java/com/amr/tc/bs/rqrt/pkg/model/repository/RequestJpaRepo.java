package com.amr.tc.bs.rqrt.pkg.model.repository;

import com.amr.tc.bs.rqrt.pkg.model.RequestJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestJpaRepo extends JpaRepository<RequestJpaEnt, UUID> {

}
