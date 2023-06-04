package com.amr.tc.bs.car.carapp.service.cmd.update;


import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UpdateCarCmd {


    private UUID carId;

    private UUID vimId;

    private UUID typeModelId;

    private UUID engineId;

    private UUID bodyId;

    private UUID brakeId;

    private UUID suspensionId;

    private UUID gearBoxId;

}






