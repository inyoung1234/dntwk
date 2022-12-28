package com.dntwk.jwt.controller;

import com.dntwk.jwt.dto.TokenDTO;
import com.dntwk.jwt.dto.TokenReqDTO;
import com.dntwk.user.dto.CreateUserDTO;
import com.dntwk.user.dto.LoginDTO;
import com.dntwk.user.dto.UserDTO;
import com.dntwk.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public UserDTO signup(@RequestBody CreateUserDTO createUserDTO) {
        log.debug("memberRequestDto = {}",createUserDTO);
        return authService.signup(createUserDTO);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDTO loginReqDTO, HttpServletResponse response) {
        TokenDTO tokenDTO = authService.login(loginReqDTO);
        addCookie(response, tokenDTO);
    }

    @GetMapping("/reissue-page")
    public ModelAndView reissuePage(ModelAndView modelAndView){
        modelAndView.setViewName("/reissue-page");
        return modelAndView;
    }

    @PostMapping("/reissue")
    public void reissue(@RequestBody TokenReqDTO tokenRequestDto, HttpServletResponse response) {
        log.info("jwt 재발행");
        System.out.println(tokenRequestDto.getAccessToken());
        System.out.println(tokenRequestDto.getRefreshToken());

        TokenDTO tokenDTO = authService.reissue(tokenRequestDto);
        addCookie(response, tokenDTO);
    }

    private void addCookie(HttpServletResponse response, TokenDTO tokenDTO) {
        Cookie cookie = new Cookie("dntwk",tokenDTO.getAccessToken());
        cookie.setMaxAge(60*60*24*30);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        Cookie cookie1 = new Cookie("_dntwk",tokenDTO.getRefreshToken());
        cookie1.setMaxAge(60*60*24*30);
        cookie1.setHttpOnly(true);
        cookie1.setPath("/auth/reissue");
        response.addCookie(cookie1);
    }
}
