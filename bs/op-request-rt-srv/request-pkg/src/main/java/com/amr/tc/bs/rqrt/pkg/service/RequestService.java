package com.amr.tc.bs.rqrt.pkg.service;

import com.amr.tc.bs.rqrt.pkg.controller.request.CreateRequestItemReq;
import com.amr.tc.bs.rqrt.pkg.controller.request.CreateRequestReq;
import com.amr.tc.bs.rqrt.pkg.model.RequestCarItemJpaEnt;
import com.amr.tc.bs.rqrt.pkg.model.RequestJpaEnt;
import com.amr.tc.bs.rqrt.pkg.model.repository.RequestJpaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RequestService {

    private final RequestJpaRepo requestJpaRepo;

    public void create_request(CreateRequestReq createRequestReq) {

        RequestJpaEnt request = new RequestJpaEnt();
        request.setRequestId(createRequestReq.getRequestId());
        request.setTrackingId(createRequestReq.getTrackingId());
        List<RequestCarItemJpaEnt> carItems = createRequestReq.getCarItems().stream().map(this::mapToDto).toList();
        request.setCarItems(carItems);
        requestJpaRepo.save(request);

    }

    private RequestCarItemJpaEnt mapToDto(CreateRequestItemReq orderLineItemsDto) {

        return RequestCarItemJpaEnt.builder()
                                   .requestCarItemId(orderLineItemsDto.getRequestCarItemId())
                                   .parkingId(orderLineItemsDto.getParkingId())
                                   .price(orderLineItemsDto.getPrice())
                                   .quantity(orderLineItemsDto.getQuantity())
                                   .build();

    }

}
