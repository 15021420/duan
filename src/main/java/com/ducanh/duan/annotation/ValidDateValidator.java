package com.ducanh.duan.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String>{

    String dateFormat;

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        dateFormat = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }
        if (value.length() != dateFormat.length()) {
            return false;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            Date date = simpleDateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
