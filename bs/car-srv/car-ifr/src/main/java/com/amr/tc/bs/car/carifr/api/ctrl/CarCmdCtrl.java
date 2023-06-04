package com.amr.tc.bs.car.carifr.api.ctrl;

import com.amr.tc.bs.car.carapp.service.cmd.create.CreateCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.delete.DeleteCarCmd;
import com.amr.tc.bs.car.carapp.service.cmd.update.UpdateCarCmd;
import com.amr.tc.bs.car.carifr.api.adpt.CarCmdAdpt;
import com.amr.tc.bs.car.carifr.api.req.CreateCarReq;
import com.amr.tc.bs.car.carifr.api.req.UpdateCarReq;
import com.amr.tc.bs.car.carifr.api.util.CarCmdUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CarCmdCtrl {

    private final CarCmdAdpt commandRouting;
    private final CarCmdUtil carCmdUtil;

    @GetMapping("/car/health-check-command")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "car-command");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/car")
    public ResponseEntity<?> save_car(@Valid @RequestBody CreateCarReq request) throws MalformedURLException {

        CreateCarCmd cmd = new CreateCarCmd();
        BeanUtils.copyProperties(request, cmd);
        commandRouting.save_customer(cmd);

        HttpHeaders headers = new HttpHeaders();
        headers.add("linkGetItem", carCmdUtil.header_get_link_Item("/{id}", cmd.getCarId()));
        headers.add("linkAllItem", carCmdUtil.header_get_item_list("/{id}"));


        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/car/{id}")
    public ResponseEntity<?> update_car(@PathVariable("id") UUID id, @Valid @RequestBody UpdateCarReq request) {

        UpdateCarCmd cmd = new UpdateCarCmd();
        BeanUtils.copyProperties(request, cmd);

        cmd.setCarId(id);
        commandRouting.update_customer(cmd);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> delete_car(@PathVariable("id") UUID id) {

        commandRouting.delete_customer(new DeleteCarCmd(id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("linkGetItem", carCmdUtil.header_get_link_Item("/{id}", id));
        headers.add("linkAllItem", carCmdUtil.header_get_item_list("/{id}"));


        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);

    }

}
