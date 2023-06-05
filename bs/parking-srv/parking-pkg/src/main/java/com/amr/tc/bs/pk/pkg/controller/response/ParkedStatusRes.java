package com.amr.tc.bs.pk.pkg.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkedStatusRes {

    private UUID parkedId;
    private boolean isAvailable;

}
