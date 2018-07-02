package com.core.valid;

import com.core.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright
 * FileName: PhoneValid
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 20:52
 * @since 1.0.0
 */
public class PhoneValid implements ConstraintValidator<Phone,String> {

    String reg ="^[1][3,4,5,7,8][0-9]{9}$";

    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value!=null&&value.matches(reg)) {
            return true;
        }
        return false;
    }
}
