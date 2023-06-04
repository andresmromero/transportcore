package com.amr.tc.bs.car.cardom.main.port.out;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;

import java.util.List;
import java.util.Optional;

public interface ICarPersSvc {

    void save(CarAgg car);

    void delete_by_id(CarId carId);

    void update_by_id(CarAgg car);

    List<CarAgg> get_all_customer();

    Optional<CarAgg> get_customer_by_id(CarId carId);

}
