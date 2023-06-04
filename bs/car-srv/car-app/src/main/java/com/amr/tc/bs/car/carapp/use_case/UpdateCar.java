package com.amr.tc.bs.car.carapp.use_case;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.port.in.IUpdateCar;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AppComp
@AllArgsConstructor
public class UpdateCar implements IUpdateCar {

    private final ICarPersSvc persist;

    @Transactional
    public void invoke(CarAgg command) {

        persist.update_by_id(command);

    }

}
