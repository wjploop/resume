package com.loop.resume.service;


import com.loop.resume.common.ServerResponse;

public interface IResumeService {

    ServerResponse list(String keyword);

    ServerResponse detail(Integer resumeId);

}
