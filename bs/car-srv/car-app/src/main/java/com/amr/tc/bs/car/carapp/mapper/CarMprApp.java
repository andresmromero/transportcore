package com.amr.tc.bs.car.carapp.mapper;

import com.amr.tc.bs.car.carapp.service.cmd.create.CreateCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.update.UpdateCarCmd;
import com.amr.tc.bs.car.carapp.service.qry.get.resp.GetCarResp;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarElem;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarQryRes;
import com.amr.tc.bs.car.cardom.main.dto.CarAggDto;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.mdl.vo.*;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Function;

@AppComp
public class CarMprApp {


    public static CarAggDto.CarAggDtoBuilder main_car_to_carAggDto(CarAgg c) {

        return CarAggDto.builder()
                        .carId(c.getId().getValue())
                        .vimId(c.getVimId().getValue())
                        .typeModelId(c.getTypeModelId().getValue())
                        .engineId(c.getEngineId().getValue())
                        .bodyId(c.getBodyId().getValue())
                        .brakeId(c.getBrakeId().getValue())
                        .suspensionId(c.getSuspensionId().getValue())
                        .gearBoxId(c.getGearBoxId().getValue());
    }

    private static Function<CarAgg, GetAllCarElem> carItem_to_getAllCarElemItem() {

        return c -> {
            CarAggDto dto = main_car_to_carAggDto(c).build();
            GetAllCarElem res = new GetAllCarElem();
            BeanUtils.copyProperties(dto, res);
            return res;
        };
    }

    public CarAgg.Builder main_carDto_to_carAgg(CarAggDto c) {

        return CarAgg.Builder.builder()
                             .carId(new CarId(c.getCarId()))
                             .vimId(new CarVimId(c.getVimId()))
                             .typeModelId(new CarTypeModelId(c.getTypeModelId()))
                             .engineId(new CarEngineId(c.getEngineId()))
                             .bodyId(new CarBodyId(c.getBodyId()))
                             .brakeId(new CarBrakeId(c.getBrakeId()))
                             .suspensionId(new CarSuspensionId(c.getSuspensionId()))
                             .gearBoxId(new CarGearBoxId(c.getGearBoxId()));
    }

    public CarAgg createCarCmd_to_car(CreateCarCmd c) {

        CarAggDto dto = new CarAggDto();
        BeanUtils.copyProperties(c, dto);
        return main_carDto_to_carAgg(dto).build();
    }

    public CarAgg updateCarCmd_to_car(UpdateCarCmd c) {

        CarAggDto dto = new CarAggDto();
        BeanUtils.copyProperties(c, dto);
        return main_carDto_to_carAgg(dto).build();
    }

    public GetAllCarQryRes car_to_getAllCarQryRes(List<CarAgg> modelEntityList) {

        List<GetAllCarElem> elem = modelEntityList.stream().map(carItem_to_getAllCarElemItem()).toList();
        return GetAllCarQryRes.builder().cars(elem).build();
    }

    public GetCarResp car_to_getCarResp(CarAgg c) {

        CarAggDto dto = main_car_to_carAggDto(c).build();
        GetCarResp res = new GetCarResp();
        BeanUtils.copyProperties(dto, res);
        return res;
    }

}
