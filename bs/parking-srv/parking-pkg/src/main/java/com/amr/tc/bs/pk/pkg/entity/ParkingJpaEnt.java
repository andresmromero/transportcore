package com.amr.tc.bs.pk.pkg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(schema = "status_parked")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingJpaEnt {

    @Id
    private UUID parkingId;
    private UUID parkedId;
    private Integer quantity;

}
