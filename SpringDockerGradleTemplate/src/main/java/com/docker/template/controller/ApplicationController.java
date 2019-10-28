package com.docker.template.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @RequestMapping("/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue="World" ) String name){
        return "Hello "+ name +"!!!";
    }
}
