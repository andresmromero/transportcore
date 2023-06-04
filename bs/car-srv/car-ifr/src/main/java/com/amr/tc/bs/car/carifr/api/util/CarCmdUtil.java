package com.amr.tc.bs.car.carifr.api.util;

import com.amr.tc.shared.shdbs.infra.annot.InfraComp;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@InfraComp
public class CarCmdUtil {


    public String header_get_link_Item(String relativePath, UUID id) {

        return ServletUriComponentsBuilder.fromCurrentRequest().path(relativePath).buildAndExpand(id).toUri().toString();

    }

    public String header_get_item_list(String relativePath) {

        return ServletUriComponentsBuilder.fromCurrentRequest().path(relativePath).buildAndExpand("").toUri().toString();
    }

}
