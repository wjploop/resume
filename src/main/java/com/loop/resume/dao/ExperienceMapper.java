package com.loop.resume.dao;

import com.loop.resume.pojo.Education;
import com.loop.resume.pojo.Experience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Experience record);

    int insertSelective(Experience record);

    Experience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKeyWithBLOBs(Experience record);

    int updateByPrimaryKey(Experience record);

    List<Experience> selectByResumeId(@Param("resumeId") Integer resumeId);
}