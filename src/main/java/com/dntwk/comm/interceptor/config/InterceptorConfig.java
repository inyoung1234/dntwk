package com.dntwk.comm.interceptor.config;

import com.dntwk.comm.interceptor.AddDirectoryListInterceptor;
import com.dntwk.directory.repository.DirectoryRepository;
import com.dntwk.directory.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AddDirectoryListInterceptor addDirectoryListInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(addDirectoryListInterceptor) // <--변경
                .addPathPatterns("/**");
    }


}
