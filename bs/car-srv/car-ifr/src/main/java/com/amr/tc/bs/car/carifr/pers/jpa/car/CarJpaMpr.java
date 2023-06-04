package com.amr.tc.bs.car.carifr.pers.jpa.car;

import com.amr.tc.bs.car.cardom.main.dto.CarAggDto;
import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.mdl.vo.*;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import com.amr.tc.shared.shdbs.infra.annot.InfraComp;
import org.springframework.beans.BeanUtils;

@InfraComp
public class CarJpaMpr {

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

    public CarJpaEnt car_to_carEntity(CarAgg c) {

        CarJpaEnt entity = new CarJpaEnt();
        CarAggDto dto = main_car_to_carAggDto(c).build();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CarJpaEnt prepare_car_entity_for_update(CarAgg c) {

        return car_to_carEntity(c);
    }


    public CarAgg carEntity_to_car(CarJpaEnt c) {

        CarAggDto dto = new CarAggDto();
        BeanUtils.copyProperties(c, dto);
        return main_carDto_to_carAgg(dto).build();
    }

}
