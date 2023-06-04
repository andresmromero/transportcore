package com.amr.tc.bs.car.carapp.use_case;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.port.in.IGetAllCar;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AppComp
@AllArgsConstructor
public class GetAllCar implements IGetAllCar {

    private final ICarPersSvc persist;

    @Transactional(readOnly = true)
    public List<CarAgg> invoke() {

        return persist.get_all_customer();
    }

}
