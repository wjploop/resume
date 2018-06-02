package com.loop.resume.controller;

import com.loop.resume.common.ServerResponse;
import com.loop.resume.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    IResumeService iResumeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ServerResponse list( String keyword) {
        return iResumeService.list(keyword);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ServerResponse detail(@RequestParam Integer id) {
        return iResumeService.detail(id);
    }

}
