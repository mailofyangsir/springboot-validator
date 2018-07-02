package com.core;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Copyright
 * FileName: Application
 * Description:
 * starter
 *
 * @author sir
 * @create 2018/7/2 20:36
 * @since 1.0.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 配置校验快速失败
     *
     * @return
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory =
                Validation.byProvider(HibernateValidator.class)
                        .configure()
                        .failFast(true)
                        .buildValidatorFactory();

        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        //模式是普通模式 会校验所有的字段，此处设置为快速失败模式，使用上面创建的bean
        methodValidationPostProcessor.setValidator(validator());
        return methodValidationPostProcessor;
    }

    //通过字符串设值
    //@Bean
    public Validator validator1() {
        ValidatorFactory validatorFactory =
                Validation.byProvider(HibernateValidator.class)
                        .configure()
                        .addProperty("hibernate.validator.fail_fast", "true")
                        .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;

    }
}
