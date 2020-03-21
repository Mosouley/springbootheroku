package com.moh.springbootheroku.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIsController {


    @RequestMapping("api/helloworld")
    public String findAll(){
        return "Hello World of Heroku!";
    }
}