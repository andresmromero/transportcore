package com.amr.tc.bs.car.carapp.service.qry.get.resp;

import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResp{
    private UUID carId;
    private UUID vimId;
    private UUID typeModelId;
    private UUID engineId;
    private UUID bodyId;
    private UUID brakeId;
    private UUID suspensionId;
    private UUID gearBoxId;
}
