package com.amr.tc.shared.shdbs.infra.annot;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface InfraComp {
    @AliasFor(annotation = Component.class) String value() default "";
}
