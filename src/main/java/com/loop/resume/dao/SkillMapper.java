package com.loop.resume.dao;

import com.loop.resume.pojo.Education;
import com.loop.resume.pojo.Skill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);

    List<Skill> selectByResumeId(@Param("resumeId") Integer resumeId);
}