package com.dntwk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/reissue")
    public String reissuePage(ModelAndView modelAndView){
        return "/reissue-page";
    }

    @GetMapping("/sign")
    public String sign(){
        return "/sign/signup";
    }


    @GetMapping("/admin")
    public String admin(){
        return "/admin/admin-main";
    }
}
