package com.amr.tc.bs.rqrt.pkg.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CreateRequestItemReq {
    @NotNull(message = "requestCarItemId is required")
    private UUID requestCarItemId;
    @NotNull(message = "parkingId is required")

    private  UUID parkingId;
    @NotNull(message = "price is required")

    private BigDecimal price;
    @NotNull(message = "quantity is required")

    private  Integer quantity;

}

