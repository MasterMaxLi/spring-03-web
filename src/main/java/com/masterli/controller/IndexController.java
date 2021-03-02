package com.masterli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Creqated by Limingxuan on 2021/2/28
 */
@Controller
public class IndexController {

    @RequestMapping ("/test")
    public String test(Model model){
        model.addAttribute("msg", "<h1>hello springboot</h1>");
        model.addAttribute("users", Arrays.asList("张三", "李四", "王二", "麻子"));
        return "test";
    }
}
