package com.dntwk;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletRequest;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
