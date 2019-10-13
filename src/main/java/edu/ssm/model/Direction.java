package edu.ssm.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
public class Direction {
    private Integer id;
    private String name;
    private String introduction;
    private String target;
    @Column(name = "dir_number")
    private Integer number;
    @Column(name = "dir_selNumber")
    private Integer selectNumber;

    private List<Course> courses;
    private List<Teacher> teachers;
    private String courseStr;
    private Integer selNumber;
    private Date dirLimitStart;
    private Date dirLimitEnd;
    private Major major;
    private String majorId;
}
