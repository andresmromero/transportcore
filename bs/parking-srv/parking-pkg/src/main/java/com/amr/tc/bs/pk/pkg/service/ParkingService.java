package com.amr.tc.bs.pk.pkg.service;

import com.amr.tc.bs.pk.pkg.controller.request.ParkedStatusReq;
import com.amr.tc.bs.pk.pkg.controller.response.ParkedStatusRes;
import com.amr.tc.bs.pk.pkg.entity.repository.ParkingRepo;
import com.amr.tc.shared.shdbs.app.annot.AppComp;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AppComp
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepo parkingRepo;

    @Transactional(readOnly = true)
    public List<ParkedStatusRes> isInParking(ParkedStatusReq parkingIdList) {

        return parkingRepo.findByParkedIdIn(parkingIdList.getParkedIdList())
                          .stream()
                          .map(p -> ParkedStatusRes.builder()
                                                   .parkedId(p.getParkedId())
                                                   .isAvailable(p.getQuantity() > 0)
                                                   .build())
                          .toList();

    }

}
