package com.dntwk.comm.interceptor;

import com.dntwk.directory.dto.SortedDirectoryListDTO;
import com.dntwk.directory.entity.Directory;
import com.dntwk.directory.service.DirectoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AddDirectoryListInterceptor implements HandlerInterceptor {

    private final DirectoryService directoryService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        System.out.println(directoryService.findSortedDirectoryList());
        List<SortedDirectoryListDTO> directoryList = directoryService.findSortedDirectoryList();
        if(directoryList!=null&&modelAndView!=null) {
            modelAndView.addObject("directoryList",directoryList);
        }
    }
}
