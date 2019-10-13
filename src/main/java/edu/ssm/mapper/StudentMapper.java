package edu.ssm.mapper;

import edu.ssm.model.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 学生选方向
     * @param
     */
    void pickDir(@Param("dirId") int dirId, @Param("stuId") int stuId);

    List<Direction> selectDir(@Param("id") int id, @Param("date") String date);

    String selectCourseId(Integer id);

    List<Course> selectCourses(@Param("ids") List<Integer> ids);

    /**
     * 根据方向id获取课程id列表
     * @param id
     * @return
     */
    List<DirectionCourse> selectCourseIds(int id);

    Direction selectOneDir(int id);

    Teacher selectTeacher(int teacherId);

    /**
     * 根据课程id获取老师id列表
     * @param courseId
     * @return
     */
    List<TeacherCourse> selectTeacherIds(int courseId);

    Direction selectDirNumber(int dirId);

    void updateNum(int dirId);

    void updatePassword(@Param("id") Integer id, @Param("password") String password);

    void updateOldNum(int oldDirId);
}
