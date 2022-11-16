package com.dntwk.comm.interceptor;

import com.dntwk.directory.entity.Directory;
import com.dntwk.directory.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AddDirectoryListInterceptor implements HandlerInterceptor {

    @Autowired
    private DirectoryService directoryService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

//        List<Directory> directoryList = directoryService.getDirectoryList();
//        System.out.println(directoryList);
//        modelAndView.addObject("directoryList",directoryList);

    }
}