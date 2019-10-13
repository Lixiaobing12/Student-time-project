package edu.ssm.mapper;

import edu.ssm.model.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorMapper {
    Major selectByPrimaryKey(@Param("id")Integer id);
    List<Major> selectAllMajor();
    void insertMajor(@Param("name")String name,@Param("pastern")String pastern);
    void delById(@Param("id")String id);
}
