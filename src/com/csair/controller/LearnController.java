package com.csair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 学习中心
 */
@Controller
@RequestMapping(value = "/learn")
public class LearnController {
    @RequestMapping("/thread")
    public String learnThread(HttpServletRequest request){
        return "learn/thread";
    }
    @RequestMapping("/tool")
    public String learnTool(HttpServletRequest request){
        return "learn/tool";
    }
}
