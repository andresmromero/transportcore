package com.amr.tc.bs.car.carapp.use_case;

import com.amr.tc.bs.car.cardom.main.port.in.IDeleteCarUc;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AppComp
@AllArgsConstructor
public class DeleteCar implements IDeleteCarUc {

    private final ICarPersSvc persist;

    @Transactional
    public void invoke(CarId carId) {

        persist.delete_by_id(carId);

    }

}
