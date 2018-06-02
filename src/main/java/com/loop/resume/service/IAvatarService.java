package com.loop.resume.service;

import com.loop.resume.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IAvatarService {

    ServerResponse getImg(Integer id);

    ServerResponse putImg(MultipartFile file);
}
