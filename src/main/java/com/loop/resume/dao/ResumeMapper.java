package com.loop.resume.dao;

import com.loop.resume.pojo.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    List select(@Param("keyword") String keyword);
}