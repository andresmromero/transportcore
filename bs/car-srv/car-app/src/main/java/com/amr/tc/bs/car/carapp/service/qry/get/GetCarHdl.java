package com.amr.tc.bs.car.carapp.service.qry.get;

import com.amr.tc.bs.car.carapp.mapper.CarMprApp;
import com.amr.tc.bs.car.carapp.service.qry.get.resp.GetCarResp;
import com.amr.tc.bs.car.carapp.use_case.GetCar;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@AppComp
public class GetCarHdl {

    private final GetCar getCar;
private final CarMprApp commandMapperApp;
    @Transactional
    public GetCarResp invoke(GetCarQry query) {


        CarAgg car = getCar.invoke(new CarId(query.getCarId()));
        return commandMapperApp.car_to_getCarResp(car);
    }

}
