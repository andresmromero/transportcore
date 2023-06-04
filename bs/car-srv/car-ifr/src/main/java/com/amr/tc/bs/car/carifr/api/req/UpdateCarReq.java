package com.amr.tc.bs.car.carifr.api.req;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UpdateCarReq {


    private UUID carId;

    private UUID vimId;

    private UUID typeModelId;

    private UUID engineId;

    private UUID bodyId;

    private UUID brakeId;

    private UUID suspensionId;

    private UUID gearBoxId;

}
