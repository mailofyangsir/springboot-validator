package com.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Copyright
 * FileName: GlobalException
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 21:49
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object processException(Exception e) {

        if (e instanceof ConstraintViolationException) {
            e.printStackTrace();
            //
            ConstraintViolationException ve = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
            StringBuilder sb = new StringBuilder();
            //获取验证信息
            for (ConstraintViolation cv : violations) {
                String msg = cv.getMessage();
                System.out.println(msg);
                sb.append(msg).append(" ");
            }
            return sb.toString();
        }

        return "fail";
    }

}
