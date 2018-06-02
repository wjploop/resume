package com.loop.resume.controller;

import com.loop.resume.common.ServerResponse;
import com.loop.resume.service.IAvatarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    Logger log = LoggerFactory.getLogger(AvatarController.class);

    @Autowired
    public IAvatarService iAvatarService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ServerResponse getImg(@RequestParam Integer id) {

        return iAvatarService.getImg(id);

    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ServerResponse putImg(MultipartFile  file) {

        log.info(file.getName());
        log.info(file.getContentType());
        log.info(String.valueOf(file.getSize()));

        return iAvatarService.putImg(file);
    }

}
