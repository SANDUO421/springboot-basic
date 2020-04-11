package com.springboot.thymeleaf.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 三多
 * @Time 2020/4/11
 */
@Data
public class User implements Serializable {
    private Long uid ;
    private String name ;
    private Integer age ;
    private Date birthday ;
    private Double salary ;
}
