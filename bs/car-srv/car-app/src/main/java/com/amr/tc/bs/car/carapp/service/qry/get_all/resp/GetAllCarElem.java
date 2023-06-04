package com.amr.tc.bs.car.carapp.service.qry.get_all.resp;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarElem {

    private UUID carId;
    private UUID vimId;
    private UUID typeModelId;
    private UUID engineId;
    private UUID bodyId;
    private UUID brakeId;
    private UUID suspensionId;
    private UUID gearBoxId;

}
