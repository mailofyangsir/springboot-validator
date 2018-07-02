package com.core.controller;

import com.core.flag.Second;
import com.core.pojo.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Copyright
 * FileName: DemoController
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 20:39
 * @since 1.0.0
 */

@RestController
@Validated
public class DemoController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping(value = "/user")
    public Object getUser(@Validated(Second.class) User user, BindingResult result) {

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            Locale locale = LocaleContextHolder.getLocale();

            for (FieldError error : fieldErrors) {
                String msg = messageSource.getMessage(error, locale);
                sb.append(error.getField()).append(":").append(msg);
            }

            System.out.println(sb.toString());
            return sb.toString();
        }
        return "success";
    }


    @GetMapping("/login")
    public Object validUser(
            @NotBlank(message = "不能为空")
            String username,
            @NotBlank(message = "not be empty")
            String password) {


        return "success";
    }



}
