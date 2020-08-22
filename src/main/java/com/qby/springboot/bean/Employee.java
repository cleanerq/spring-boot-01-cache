package com.qby.springboot.bean;

import lombok.*;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
