package edu.ssm.service.impl;

import edu.ssm.mapper.StudentMapper;
import edu.ssm.model.*;
import edu.ssm.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public int regist(Student student) {
        studentMapper.insert(student);
        return 0;
    }

    public int repeat(Student student) {

        return studentMapper.select(student).size();
    }

    /**
     * 登陆
     * @param student
     * @return
     */
    public Student login(Student student) {
        Student realStudent = studentMapper.selectOne(student);
        return realStudent;
    }

    public void update(Integer id, String password) {
        studentMapper.updatePassword(id, password);
    }

    /**
     * 学生选方向
     * @param
     * @return
     */
    public boolean pickDir(int dirId, int oldDirId,  int stuId) {
        studentMapper.pickDir(dirId, stuId);
        studentMapper.updateNum(dirId);
        studentMapper.updateOldNum(oldDirId);
        return true;
    }

    /**
     * 所有方向名称
     * @param
     * @return
     */
    public List<Direction> selectDirName(int id) {
        Date date = new Date();
        String strDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            strDate = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentMapper.selectDir(id, strDate);
    }

    /**
     * 显示详情
     * @param id  方向id
     * @return
     */
    public Direction showDetail(int id) {
        //获取方向
        Direction direction = studentMapper.selectOneDir(id);
        //根据方向的id获取对应的课程id
        List<DirectionCourse> tempCourse = studentMapper.selectCourseIds(id) ;
        List<Integer> coursesIds = new ArrayList<Integer>(tempCourse.size());
        for (int i = 0, k = tempCourse.size(); i < k; i++) {
            coursesIds.add(tempCourse.get(i).getCourseId());
        }
//        //获取所有课程
        List<Course> courses = studentMapper.selectCourses(coursesIds);
        List<Teacher> teachers = new ArrayList<Teacher>(courses.size());
        HashMap<Integer, Teacher> teacherMap = new HashMap<Integer, Teacher>();
        //遍历课程列表，根据课程获取老师信息
        for (int i = 0, k = courses.size(); i < k; i++) {
            //选获取课程对应的老师id列表

            List<TeacherCourse> tempTeachers = studentMapper.selectTeacherIds(coursesIds.get(i));
            List<Integer> teacherIds = new ArrayList<Integer>(tempTeachers.size());
            for (int j = 0, h = tempTeachers.size(); j < h; j++) {
                teacherIds.add(tempTeachers.get(j).getTeacherId());
            }
            for (int n = 0, m = teacherIds.size(); n < m; n++) {
                //根据获取的id逐一获取老师信息
                //用map是为了去除重复出现的老师
                int tId = teacherIds.get(n);
                //如果等于空说明没出现过
                if (teacherMap.get(tId) == null) {
                    teacherMap.put(tId, studentMapper.selectTeacher(tId));
                }
            }
        }
        //遍历map把老师信息添加到list集合
        for (Map.Entry<Integer, Teacher> entry : teacherMap.entrySet()) {
            teachers.add(entry.getValue());
        }
        direction.setCourses(courses);
        direction.setTeachers(teachers);
        return direction;
    }

    public boolean selectDir(int dirId) {
        Direction direction = studentMapper.selectDirNumber(dirId);
        return direction.getSelectNumber() < direction.getNumber();
    }

    public void importStudents(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            boolean is03Excel = file.getOriginalFilename().matches("^.+\\.(?i)(xls)$");
            //1、读取工作簿
            Workbook workbook = is03Excel ? new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
            //2、读取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //3、读取行
            int num = sheet.getPhysicalNumberOfRows();
            System.out.println("num:" + num);
            if( num >= 1){
                Student student = null;
                for(int k = 1; k < num; k++){
                    //4、读取单元格
                    Row row = sheet.getRow(k);
                    student = new Student();
                    Cell cell0 = row.getCell(0);
                    student.setName((cell0.getStringCellValue()));
                    Cell cell1 = row.getCell(1);
                    student.setPassword(String.valueOf((int)cell1.getNumericCellValue()));
                    Cell cell2 = row.getCell(2);
                    student.setNumber(String.valueOf((int)cell1.getNumericCellValue()));
                    Cell cell3 = row.getCell(3);
                    student.setMajor((int)cell3.getNumericCellValue());
                    studentMapper.insert(student);
                }
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
