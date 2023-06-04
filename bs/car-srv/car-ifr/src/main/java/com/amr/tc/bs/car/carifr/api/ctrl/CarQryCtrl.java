package com.amr.tc.bs.car.carifr.api.ctrl;

import com.amr.tc.bs.car.carapp.service.qry.get.GetCarQry;
import com.amr.tc.bs.car.carapp.service.qry.get.resp.GetCarResp;
import com.amr.tc.bs.car.carapp.service.qry.get_all.resp.GetAllCarQryRes;
import com.amr.tc.bs.car.carifr.api.adpt.CarQryAdpt;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CarQryCtrl {

    private final CarQryAdpt queryRouting;

    @GetMapping("/car/health-check-query")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "car-query");
        status.put("status", "ok");
        return status;
    }


    @GetMapping("/car")
    public ResponseEntity<GetAllCarQryRes> get_all() {

        GetAllCarQryRes res = queryRouting.get_all_customers();

        if (res == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<GetCarResp> get_car(@PathVariable("id") UUID id) {

        GetCarResp res = queryRouting.get_customer(new GetCarQry(id));
        if (res == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
