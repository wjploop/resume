package com.loop.resume.dao;

import com.loop.resume.pojo.Avatar;

public interface AvatarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Avatar record);

    int insertSelective(Avatar record);

    Avatar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Avatar record);

    int updateByPrimaryKeyWithBLOBs(Avatar record);
}