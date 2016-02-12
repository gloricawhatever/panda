package com.elbowcorp.infra.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        System.out.println("test");
        return "index.html";
    }

}
