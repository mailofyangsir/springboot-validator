package com.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Locale;

/**
 * Copyright
 * FileName: ValidUtil
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 21:09
 * @since 1.0.0
 */
public class ValidUtil {

    public static final String VALID_SUCCESS="success";


    public static Logger logger = LoggerFactory.getLogger(ValidUtil.class);


    public static String valid(MessageSource messageSource, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();

            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : fieldErrors) {
                String msg = messageSource.getMessage(fieldError, locale);
                sb.append(fieldError.getField()).append(":").append(msg);
            }
            logger.info(sb.toString());
            return sb.toString();
        }
        return VALID_SUCCESS;
    }


}
