package com.ducanh.duan.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidDateValidator.class)
public @interface ValidDate {

    String message() default "Ngày tháng không hợp lệ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String format() default "yyyy-MM-dd";

    @Target({ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ValidDate[] value();
    }
}
