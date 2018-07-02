package com.core.valid;

import com.core.annotation.FlagValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright
 * FileName: FlagValidator
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 20:43
 * @since 1.0.0
 */
public class FlagValidator implements ConstraintValidator<FlagValid, String> {

   private String values;

   public void initialize(FlagValid constraint) {
      this.values=constraint.values();
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      String[] strs = values.split(",");
      for (String s : strs) {
         if (s.equals(value)) {
            //验证通过
            return true;
         }
      }
      return false;
   }


}
