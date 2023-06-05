package com.amr.tc.bs.rqrt.pkg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "request_car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestJpaEnt {

    @Id
    private UUID requestId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RequestCarItemJpaEnt> carItems;
    private UUID trackingId;
}
