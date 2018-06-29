package com.demo.provider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体
 *
 * @author liugang
 * @since 2018-06-28
 */
@Data
public class User implements Serializable{


    private static final long serialVersionUID = 2124760393087190891L;
    private Integer id;
    private Integer age;
    private String name;

    private Integer port;
}
