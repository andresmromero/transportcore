package com.amr.tc.shared.shdbs.dom.vo;

import java.util.Objects;

public abstract class AttributeId<TYPE> {

    private final TYPE value;

    public AttributeId(TYPE value) {

        this.value = value;
    }

    public TYPE getValue() {

        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttributeId<?> that = (AttributeId<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
