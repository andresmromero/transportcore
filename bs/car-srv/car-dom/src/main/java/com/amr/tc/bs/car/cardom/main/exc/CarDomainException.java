package com.amr.tc.bs.car.cardom.main.exc;

import com.amr.tc.shared.shdbs.dom.exc.DomainException;

public class CarDomainException extends DomainException {

    public CarDomainException(String message) {

        super(message);
    }

    public CarDomainException(String message, Throwable cause) {

        super(message, cause);
    }

}
