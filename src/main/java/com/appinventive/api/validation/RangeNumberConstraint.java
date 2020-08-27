package com.appinventive.api.validation;


import com.appinventive.api.validation.RangeNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RangeNumberValidator.class})
public @interface RangeNumberConstraint {

    String message() default "Rating should be between 0.5 and 4.5.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}