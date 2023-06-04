package com.amr.tc.bs.car.carapp.service.cmd.delete;


import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class DeleteCarCmd {


    private UUID carId;

}
