package edu.ssm.mapper;

import edu.ssm.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    void insertTeacher(@Param("name")String name,@Param("intro")String intro);
    void delTeacher(@Param("id")Integer id);
    void selectByPrimaryKey(@Param("id")Integer id);
    List<Teacher> selectAllTeacher();
}
