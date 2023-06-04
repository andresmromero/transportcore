package com.amr.tc.bs.car.carifr.pers.jpa.car;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "cars")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarJpaEnt {

    @Id
    private UUID carId;
    @Column
    private UUID vimId;
    @Column
    private UUID typeModelId;
    @Column
    private UUID engineId;
    @Column
    private UUID bodyId;
    @Column
    private UUID brakeId;
    @Column
    private UUID suspensionId;
    @Column
    private UUID gearBoxId;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarJpaEnt carJpaEnt = (CarJpaEnt) o;
        return carId.equals(carJpaEnt.carId) && Objects.equals(vimId, carJpaEnt.vimId) &&
                Objects.equals(typeModelId, carJpaEnt.typeModelId) &&
                Objects.equals(engineId, carJpaEnt.engineId) && Objects.equals(bodyId, carJpaEnt.bodyId) &&
                Objects.equals(brakeId, carJpaEnt.brakeId) && Objects.equals(suspensionId, carJpaEnt.suspensionId) &&
                Objects.equals(gearBoxId, carJpaEnt.gearBoxId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, vimId, typeModelId, engineId, bodyId, brakeId, suspensionId, gearBoxId);
    }

}
