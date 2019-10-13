package edu.ssm.service;

import edu.ssm.model.Course;
import edu.ssm.model.Direction;
import edu.ssm.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
public interface StudentService {

    /**
     * 注册
     * @param student
     * @return
     */
    int regist(Student student);

    /**
     * 检查学生是已注册
     * @param student
     * @return
     */
    int repeat(Student student);

    /**
     * 登陆
     * @param student
     * @return
     */
    Student login(Student student);

    void update(Integer id, String password);


    /**
     * 学生选方向
     * @param id
     * @return
     */
    boolean pickDir(int dirId, int oDirId, int stuId);

    /**
     * 所有方向的信息
     * @param
     * @return
     */
    List<Direction> selectDirName(int id);

    /**
     * 显示专业详情
     * @param id
     * @return
     */
    Direction showDetail(int id);

    /**
     * 是否选课成功
     * @param dirId
     * @return
     */
    boolean selectDir(int dirId);

    void importStudents(MultipartFile file);

}
