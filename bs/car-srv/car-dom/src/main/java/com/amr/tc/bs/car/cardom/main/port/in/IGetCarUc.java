package com.amr.tc.bs.car.cardom.main.port.in;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;

public interface IGetCarUc {

     CarAgg invoke(CarId carId);
}
