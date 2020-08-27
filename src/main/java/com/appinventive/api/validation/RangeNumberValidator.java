package com.appinventive.api.validation;

import com.appinventive.api.domain.Movie;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RangeNumberValidator implements ConstraintValidator<RangeNumberConstraint, Double>  {

    public void initialize(RangeNumberConstraint constraint) {
    }

    @Override
    public boolean isValid(Double rating,
                           ConstraintValidatorContext cxt) {

        return rating != null && rating >=0.5
                && rating<=4.5;
    }
}
