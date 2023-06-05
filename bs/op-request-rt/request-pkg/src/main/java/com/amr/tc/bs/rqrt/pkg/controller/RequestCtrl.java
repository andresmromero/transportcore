package com.amr.tc.bs.rqrt.pkg.controller;

import com.amr.tc.bs.rqrt.pkg.controller.request.CreateRequestReq;
import com.amr.tc.bs.rqrt.pkg.controller.utils.RequestCtrlUtil;
import com.amr.tc.bs.rqrt.pkg.service.RequestService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/request")
public class RequestCtrl {


    private final RequestService requestService;

private final RequestCtrlUtil requestCmdUtil;

    @GetMapping("/health-check")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "request");
        status.put("status", "ok");
        return status;
    }
    @PostMapping
    public ResponseEntity<HashMap<String, String>> save_request(@Valid @RequestBody CreateRequestReq request) {

        requestService.create_request(request);
        HashMap<String, String> status = new HashMap<>();
        status.put("message", "The transportation requirement is accepted");
        return ResponseEntity.status(HttpStatus.CREATED).body(status);


    }

}
