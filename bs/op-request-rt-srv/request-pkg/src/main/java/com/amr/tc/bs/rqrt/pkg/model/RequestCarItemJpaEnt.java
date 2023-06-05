package com.amr.tc.bs.rqrt.pkg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "request_car_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCarItemJpaEnt {

    @Id
    private UUID requestCarItemId;
    private UUID parkingId;
    private BigDecimal price;
    private Integer quantity;

}
