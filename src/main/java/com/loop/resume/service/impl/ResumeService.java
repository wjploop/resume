package com.loop.resume.service.impl;

import com.loop.resume.common.ServerResponse;
import com.loop.resume.dao.*;
import com.loop.resume.pojo.*;
import com.loop.resume.service.IResumeService;
import com.loop.resume.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iResumeService")
public class ResumeService implements IResumeService {

    @Autowired
    private ResumeMapper  resumeMapper;

    @Autowired
    private AvatarMapper avatarMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PreferenceMapper preferenceMapper;

    @Override
    public ServerResponse list(String keyword) {

        List resumes = resumeMapper.select(keyword);
        ServerResponse response = ServerResponse.createBySuccess(resumes);
        return response;
    }

    @Override
    public ServerResponse detail(Integer id) {
        Resume resume = resumeMapper.selectByPrimaryKey(id);
        ResumeVo resumeVo = assembleResume(resume);

        return ServerResponse.createBySuccess(resumeVo);
    }


    private ResumeVo assembleResume(Resume resume) {
        ResumeVo resumeVo = new ResumeVo();

        List<Education> educations = educationMapper.selectByResumeId(resume.getId());
        List<Experience> experiences = experienceMapper.selectByResumeId(resume.getId());
        List<Skill> skills = skillMapper.selectByResumeId(resume.getId());

        User user = userMapper.selectByPrimaryKey(resume.getUser());
        Preference preference = preferenceMapper.selectByPrimaryKey(resume.getPreference());

        resumeVo.setEducations(educations);
        resumeVo.setExperiences(experiences);
        resumeVo.setSkills(skills);
        resumeVo.setUser(user);
        resumeVo.setPreference(preference);
        resumeVo.setAvatarId(resume.getAvatar());

        return resumeVo;
    }


}
