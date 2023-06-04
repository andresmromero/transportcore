package com.amr.tc.bs.car.carapp.use_case;

import com.amr.tc.bs.car.cardom.main.exc.CarDomainException;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.port.in.IGetCarUc;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AppComp
@AllArgsConstructor
public class GetCar implements IGetCarUc {

    private final ICarPersSvc persist;

    @Transactional(readOnly = true)
    public CarAgg invoke(CarId carId) {

        return persist.get_customer_by_id(carId)
                      .orElseThrow(() -> new CarDomainException("The customer does not exist"));
    }

}
