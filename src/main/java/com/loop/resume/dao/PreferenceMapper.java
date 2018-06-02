package com.loop.resume.dao;

import com.loop.resume.pojo.Preference;

public interface PreferenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Preference record);

    int insertSelective(Preference record);

    Preference selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Preference record);

    int updateByPrimaryKey(Preference record);
}