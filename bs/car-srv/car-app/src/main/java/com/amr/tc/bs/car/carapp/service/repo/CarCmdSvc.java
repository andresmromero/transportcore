package com.amr.tc.bs.car.carapp.service.repo;

import com.amr.tc.bs.car.carapp.service.cmd.create.CreateCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.delete.DeleteCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.update.UpdateCarCmd;
import jakarta.validation.Valid;

public interface CarCmdSvc {

    void save_customer(@Valid CreateCarCmd command);

    void update_customer(@Valid UpdateCarCmd command);

    void delete_customer(@Valid DeleteCarCmd command);

}
