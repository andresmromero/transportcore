package com.amr.tc.bs.car.carapp.service.repo;

import com.amr.tc.bs.car.carapp.service.qry.get.GetCarQry;
import com.amr.tc.bs.car.carapp.service.qry.get.resp.GetCarResp;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarQryRes;
import jakarta.validation.Valid;

public interface CarQrySvc {

    GetAllCarQryRes get_all_customers();

    GetCarResp get_customer(@Valid GetCarQry query);

}
