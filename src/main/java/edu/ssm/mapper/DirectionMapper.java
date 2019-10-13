package edu.ssm.mapper;

import edu.ssm.model.Direction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DirectionMapper {
    void insertDirection(Direction derDirection);
    void delDirection(@Param("id")Integer id);
    void insertDirCCourse(@Param("dirId")String dirId,@Param("courseId")String courseId);
    List<Direction> selectAllDirection();
    Direction selectById(@Param("id")String id);
    List<Integer> getConnectionId(@Param("id")String id);
    void update(Direction direction);
    void delConnectionById(@Param("id")String id);




}
