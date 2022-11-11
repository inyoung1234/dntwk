package com.dntwk.user.restcontroller;

import com.dntwk.user.entity.User;
import com.dntwk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class UsersRestController {

    private final UserService userService;


    @GetMapping("/go")
    public void test(){
        userService.test();
    }

    @GetMapping("/go2")
    public void tset2(){
        userService.test2();
    }
}
