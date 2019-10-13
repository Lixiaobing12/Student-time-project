package edu.ssm.model;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author Blse
 * @date 2019/8/22
 * @description
 */
@Data
public class DirectionCourse {

    private Integer id;
    private Integer courseId;
    private Integer directionId;

}
