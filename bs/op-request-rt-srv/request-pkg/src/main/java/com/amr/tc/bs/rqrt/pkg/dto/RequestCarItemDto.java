package com.amr.tc.bs.rqrt.pkg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestCarItemDto {

    private UUID requestCarItemId;
    private UUID parkingId;
    private BigDecimal price;
    private Integer quantity;

}
