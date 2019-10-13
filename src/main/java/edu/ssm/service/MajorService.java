package edu.ssm.service;

import edu.ssm.model.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAllMajor();
    void insert(String name,String pastern);
    void delMajorById(String id);
}
