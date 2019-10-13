package edu.ssm.model;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
@Data
public class Student {

    private Integer id;

    private String name;

    private String number;

    private String password;

    @Column(name = "major_id")
    private Integer major;

    private Integer direction;


}
