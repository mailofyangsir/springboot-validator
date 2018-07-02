package com.core.test;

import com.core.Application;
import com.core.flag.First;
import com.core.flag.Second;
import com.core.pojo.Cat;
import com.core.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Copyright
 * FileName: TestDemo
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 22:48
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDemo {

    @Autowired
    private Validator validator;

    /**
     * 测试Hebernate的Validator用于验证
     */
    @Test
    public void test01(){
        User user = new User();
        user.setUsername("sir");
        user.setPassword("123456");
        user.setAge(22);
        user.setEmail("mail@163.com");
        user.setFlag("2");
        user.setPhone("15408417546");
        user.setBirth("2000-01-01");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> cv : violations) {
            String msg = cv.getMessage();
            System.out.println(msg);
        }
    }

    /**
     * 测试级联验证
     */
    @Test
    public void test02(){
        User user = new User();
        user.setUsername("mimi");
        user.setPassword("abcd");
        user.setFlag("1");
        user.setEmail("mail@mail.com");
        user.setPhone("17812341234");
        user.setAge(33);
        user.setBirth("2018-07-02");
        Cat cat = new Cat();
        cat.setName("tomcat");
        cat.setAge(100);
        user.setCat(cat);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation vc : violations) {
            System.out.println(vc.getMessage());
        }
    }

    //分组校验
    @Test
    public void test03(){

        User user =new User();
        user.setAge(33);
        user.setEmail("aa@bb.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user, Second.class);
        for (ConstraintViolation cv : violations) {
            System.out.println(cv.getMessage());
        }
    }

}
