package com.dntwk.comm.interceptor.config;

import com.dntwk.comm.interceptor.AddDirectoryListInterceptor;
import com.dntwk.comm.interceptor.AddVisitorCountingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AddDirectoryListInterceptor addDirectoryListInterceptor;
    private final AddVisitorCountingInterceptor addVisitorCountingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(addDirectoryListInterceptor) // <--변경
                .addPathPatterns("/**");
        registry.addInterceptor(addVisitorCountingInterceptor) // <--변경
                .addPathPatterns("/**");
    }


}
