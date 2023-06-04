package com.amr.tc.bs.car.carifr.api.adpt;

import com.amr.tc.bs.car.carapp.service.cmd.create.CreateCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.create.CreateCarHdl;
import com.amr.tc.bs.car.carapp.service.cmd.delete.DeleteCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.delete.DeleteCarHdl;
import com.amr.tc.bs.car.carapp.service.cmd.update.UpdateCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.update.UpdateCarHdl;
import com.amr.tc.bs.car.carapp.service.repo.CarCmdSvc;
import com.amr.tc.shared.shdbs.infra.annot.InfraSvc;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@InfraSvc
@AllArgsConstructor
public class CarCmdAdpt implements CarCmdSvc {

    private final CreateCarHdl createCarHdl;
    private final UpdateCarHdl updateCarHdl;
    private final DeleteCarHdl deleteCarHdl;

    @Override
    public void save_customer(@Valid CreateCarCmd command) {

        createCarHdl.handle(command);
    }

    @Override
    public void update_customer(@Valid UpdateCarCmd command) {

        updateCarHdl.handle(command);
    }

    @Override
    public void delete_customer(@Valid DeleteCarCmd command) {

        deleteCarHdl.handle(command);
    }

}
