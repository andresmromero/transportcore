package com.amr.tc.bs.car.cardom.main.dto;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CarAggDto{


    private UUID carId;

    private UUID vimId;

    private UUID typeModelId;

    private UUID engineId;

    private UUID bodyId;

    private UUID brakeId;

    private UUID suspensionId;

    private UUID gearBoxId;


}
