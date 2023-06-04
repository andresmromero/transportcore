package com.amr.tc.bs.car.carapp.service.qry.get_all;

import com.amr.tc.bs.car.carapp.mapper.CarMprApp;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarQryRes;
import com.amr.tc.bs.car.carapp.use_case.GetAllCar;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.AllArgsConstructor;

import java.util.List;

@AppComp
@AllArgsConstructor
public class GetAllCarHdl {

    private final GetAllCar getAll;
    private final CarMprApp commandMapperApp;

    public GetAllCarQryRes invoke() {

        List<CarAgg> carList = getAll.invoke();
        return commandMapperApp.car_to_getAllCarQryRes(carList);
    }

}
