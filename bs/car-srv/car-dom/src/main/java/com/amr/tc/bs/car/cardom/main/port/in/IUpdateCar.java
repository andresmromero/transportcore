package com.amr.tc.bs.car.cardom.main.port.in;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;

public interface IUpdateCar {
    public void invoke(CarAgg command);
}
