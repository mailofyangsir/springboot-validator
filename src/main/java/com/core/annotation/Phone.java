package com.core.annotation;

import com.core.valid.PhoneValid;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Copyright
 * FileName: Phone
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 20:48
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@Constraint(validatedBy = PhoneValid.class)
public @interface Phone {

    String value() default "";

    String message() default "不符合手机号规则";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
