package edu.ssm.service;

import edu.ssm.model.Direction;
import edu.ssm.vo.ResultObject;

import java.util.List;

public interface DirectionService {
    ResultObject<Direction> getAll();
    ResultObject<String> insert(String name, String intro, String target, String[] cId,String startDate,String endDate,String majorId,String number);
    ResultObject<String> del(String dId);
    Direction selectById(String id);
    public List<Integer> getConnectionCourseId(String id);
    ResultObject<String> update(String id,String name, String intro, String target, String[] cId,String startDate,String endDate,String majorId,String number);
    public void deleteDir(String id);
}
