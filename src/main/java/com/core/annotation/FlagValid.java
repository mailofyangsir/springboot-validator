package com.core.annotation;

import com.core.valid.FlagValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解类
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Constraint(validatedBy = FlagValidator.class)
public @interface FlagValid {

    String values();

    String message() default "验证失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
