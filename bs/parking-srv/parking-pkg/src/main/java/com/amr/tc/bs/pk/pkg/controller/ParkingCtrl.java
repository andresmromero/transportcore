package com.amr.tc.bs.pk.pkg.controller;

import com.amr.tc.bs.pk.pkg.controller.request.ParkedStatusReq;
import com.amr.tc.bs.pk.pkg.controller.response.ParkedStatusRes;
import com.amr.tc.bs.pk.pkg.service.ParkingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parking")
@RequiredArgsConstructor
@Slf4j
public class ParkingCtrl {

    private final ParkingService parkingService;

    @GetMapping("/health-check")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "request");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/status-parked")
    public ResponseEntity<List<ParkedStatusRes>> status_parked(@Valid @RequestBody ParkedStatusReq request) {

        List<ParkedStatusRes> res = parkingService.isInParking(request);
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

}
