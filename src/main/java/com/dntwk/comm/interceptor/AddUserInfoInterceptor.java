package com.dntwk.comm.interceptor;

import com.dntwk.filter.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@Component
public class AddUserInfoInterceptor implements HandlerInterceptor {
    private final LoginUser loginUser;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        if (modelAndView != null) {
            modelAndView.addObject("userInfo",loginUser);
        }
    }
}
