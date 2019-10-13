package edu.ssm.service;

import edu.ssm.model.Teacher;
import edu.ssm.vo.ResultObject;

public interface TeacherService {
     ResultObject<Teacher> getAll();
     ResultObject<Teacher> del(String tId);
     ResultObject<String> add(String name, String intro);
     void delTeacherById(String id);

}
