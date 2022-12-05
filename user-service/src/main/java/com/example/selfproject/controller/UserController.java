package com.example.selfproject.controller;

import com.example.selfproject.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ApplicationUserService service;

    @Autowired
    public UserController(ApplicationUserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getDefaultPage() {
        return "default";
    }

    @GetMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView mv = new ModelAndView("home");
        String[] attributes = service.getAuthentication();
        mv.addObject("role", attributes[0]);
        mv.addObject("username", attributes[1]);
        return mv;
    }

    @GetMapping("/login")
    public String getLoginURLWhenSigned() {
        return "home";
    }
}
