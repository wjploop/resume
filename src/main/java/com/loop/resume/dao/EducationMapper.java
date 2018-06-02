package com.loop.resume.dao;

import com.loop.resume.pojo.Education;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKeyWithBLOBs(Education record);

    int updateByPrimaryKey(Education record);

    List<Education> selectByResumeId(@Param("resumeId") Integer resumeId);
}