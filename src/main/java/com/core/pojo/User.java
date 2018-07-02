package com.core.pojo;

import com.core.annotation.FlagValid;
import com.core.annotation.Phone;
import com.core.flag.First;
import com.core.flag.Second;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Copyright
 * FileName: User
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 20:46
 * @since 1.0.0
 */

@Data
@GroupSequence({First.class, Second.class, User.class})
public class User implements Serializable {

    @NotBlank(message = "username不能为空",groups = {First.class, Second.class})
    private String username;
    @NotBlank(message = "密码不能为空",groups = {First.class, Second.class})
    private String password;

    @Range(min = 1, max = 100, message = "out of range", groups = {Second.class})
    private int age;

    @Email(message = "邮箱格式不正确",groups = Second.class)
    private String email;

    //自定义注解验正
    @Phone(groups = Second.class)
    private String phone;

    //自定义注解验正
    @FlagValid(values = "1,2,3", message = "没有该值", groups = Second.class)
    private String flag;

    @Pattern(message = "生日格式不正确（yyyy-MM-dd）",regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
    private String birth;

    //级联验证
    @Valid
    @NotNull(message = "cat object not be null")
    private Cat cat;
}
