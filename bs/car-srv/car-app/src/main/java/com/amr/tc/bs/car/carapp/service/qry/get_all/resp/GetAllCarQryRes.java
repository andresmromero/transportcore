package com.amr.tc.bs.car.carapp.service.qry.get_all.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Setter
@Getter
public class GetAllCarQryRes {

    private List<GetAllCarElem> cars;

}

