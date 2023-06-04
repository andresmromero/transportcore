package com.amr.tc.bs.car.cardom.main.exc;

import com.amr.tc.shared.shdbs.dom.exc.DomainException;

public class CarNotFoundException extends DomainException {

    public CarNotFoundException(String message) {

        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }

}
