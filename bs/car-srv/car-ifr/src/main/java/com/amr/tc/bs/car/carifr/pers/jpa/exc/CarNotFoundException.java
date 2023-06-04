package com.amr.tc.bs.car.carifr.pers.jpa.exc;

import com.amr.tc.shared.shdbs.dom.exc.DomainException;

public class CarNotFoundException extends DomainException {

    public CarNotFoundException(String message) {

        super(message);
    }

}
