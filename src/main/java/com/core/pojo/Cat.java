package com.core.pojo;

import com.core.flag.First;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.groups.Default;
import java.io.Serializable;

/**
 * Copyright
 * FileName: Cat
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/2 22:58
 * @since 1.0.0
 */
@Data
@GroupSequence({First.class,Cat.class})
public class Cat implements Serializable {

    @NotBlank(message = "cat's name not be empty",groups = First.class)
    private String name;

    @Max(value = 20,message = "猫不可能成精")
    private Integer age;


}
