package com.amr.tc.bs.car.carapp.service.cmd.delete;

import com.amr.tc.bs.car.carapp.use_case.DeleteCar;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import lombok.AllArgsConstructor;

@AppComp
@AllArgsConstructor

public class DeleteCarHdl {

    private final DeleteCar deleteCar;

    public void handle(DeleteCarCmd command) {

        deleteCar.invoke(new CarId(command.getCarId()));
    }

}
