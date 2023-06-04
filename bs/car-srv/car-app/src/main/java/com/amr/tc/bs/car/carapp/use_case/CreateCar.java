package com.amr.tc.bs.car.carapp.use_case;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.port.in.ICreateCarUc;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AppComp
@AllArgsConstructor
public class CreateCar implements ICreateCarUc {

    private final ICarPersSvc persist;

    @Transactional
    public void invoke(CarAgg car) {

        persist.save(car);

    }

}
