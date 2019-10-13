package edu.ssm.mapper;

import edu.ssm.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    void insertCourse(Course course);
    void delCourse(@Param("id")Integer id);
    void insertCT(@Param("teacherId")String teacherId,@Param("courseId")String courseId);
    List<Course> selectAllCourse();
}
