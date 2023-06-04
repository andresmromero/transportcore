package com.amr.tc.bs.car.carapp.service.cmd.update;

import com.amr.tc.bs.car.carapp.mapper.CarMprApp;
import com.amr.tc.bs.car.carapp.use_case.UpdateCar;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AppComp
@AllArgsConstructor
public class UpdateCarHdl {

    private final UpdateCar updateCar;
    private final CarMprApp commandMapperApp;

    @Transactional
    public void handle(UpdateCarCmd command) {

        CarAgg model = commandMapperApp.updateCarCmd_to_car(command);
        updateCar.invoke(model);
    }

}
