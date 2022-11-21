package com.dntwk.user.controller;

import com.dntwk.comm.ApiStatus;
import com.dntwk.user.dto.CreateUserDTO;
import com.dntwk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public void getUser(){
    }

    @PostMapping("/user")
    public ApiStatus createUser(CreateUserDTO createUserDTO, ServletRequest servletRequest){
        createUserDTO.setCreateIp((String)servletRequest.getAttribute("userIp"));
        return userService.createUser(createUserDTO);
    }

    @DeleteMapping("/user")
    public void delUser(){
    }

    @PutMapping("/user")
    public void modUser(){

    }
}
