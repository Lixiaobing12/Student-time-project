package edu.ssm.model;


import lombok.Data;

import javax.persistence.Column;

@Data
public class Teacher {
    private Integer id;
    @Column(name = "teacher_name")
    private String name;
    @Column(name = "teacher_intro")
    private String introduction;
}
