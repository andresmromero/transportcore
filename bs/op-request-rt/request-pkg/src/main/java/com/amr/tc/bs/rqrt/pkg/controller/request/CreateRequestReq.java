package com.amr.tc.bs.rqrt.pkg.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CreateRequestReq {

    @NotNull(message = "RequestId is required")

    private UUID requestId;
    @NotNull(message = "trackingId is required")

    private UUID trackingId;
    @NotNull(message = "carItems is required")

    private List<CreateRequestItemReq> carItems;

}

