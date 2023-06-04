package com.amr.tc.bs.car.carifr.api.adpt;

import com.amr.tc.bs.car.carapp.service.qry.get.GetCarHdl;
import com.amr.tc.bs.car.carapp.service.qry.get.GetCarQry;
import com.amr.tc.bs.car.carapp.service.qry.get.resp.GetCarResp;
import com.amr.tc.bs.car.carapp.service.qry.get_all.GetAllCarHdl;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarQryRes;
import com.amr.tc.bs.car.carapp.service.repo.CarQrySvc;
import com.amr.tc.shared.shdbs.infra.annot.InfraSvc;
import jakarta.validation.Valid;

@InfraSvc
public class CarQryAdpt implements CarQrySvc {

    private final GetAllCarHdl getAllCarHdl;
    private final GetCarHdl getCarHdl;

    public CarQryAdpt(GetAllCarHdl getAllCarHdl, GetCarHdl getCarHdl) {

        this.getAllCarHdl = getAllCarHdl;
        this.getCarHdl = getCarHdl;
    }

    @Override
    public GetAllCarQryRes get_all_customers() {

        return getAllCarHdl.invoke();
    }

    @Override
    public GetCarResp get_customer(@Valid GetCarQry query) {

        return getCarHdl.invoke(query);
    }

}
