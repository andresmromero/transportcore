package com.amr.tc.bs.car.carapp.service.cmd.create;

import com.amr.tc.bs.car.carapp.mapper.CarMprApp;
import com.amr.tc.bs.car.carapp.use_case.CreateCar;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;

@AppComp
@AllArgsConstructor
public class CreateCarHdl {

    private final CreateCar create;
    private final CarMprApp commandMapper;

    public void handle(CreateCarCmd command) {

        CarAgg model = commandMapper.createCarCmd_to_car(command);
        create.invoke(model);
    }

}
