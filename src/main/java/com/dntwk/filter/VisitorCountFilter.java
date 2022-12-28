package com.dntwk.filter;

import com.dntwk.jwt.JwtTokenProvider;
import com.dntwk.visiter.VisitorService;
import com.dntwk.visiter.dto.VisitorReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@WebFilter(value={"/","/view"})
public class VisitorCountFilter extends OncePerRequestFilter {

    private final VisitorService visitorService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("방문자 필터 실행");
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        String agent = req.getHeader("USER-AGENT");
        if (ip == null)
            ip = req.getRemoteAddr();

        VisitorReqDTO visitorReqDTO = VisitorReqDTO.builder()
                .visitIp(ip)
                .visitRefer(getClientBrowser(agent))
                .userId(getUserEmailbyToken(request))
                .build();

        visitorService.findUserAndCounting(visitorReqDTO);

        filterChain.doFilter(request,response);
    }


    private String getUserEmailbyToken(HttpServletRequest request){
        Cookie[] cookie = request.getCookies();
        for(Cookie temp : cookie){
            if (temp.getName().equals("dntwk")){
                return jwtTokenProvider.getMemberEmailByToken(temp.getValue());
            }
        }
        return "GUEST";
    }

    public String getClientBrowser(String userAgent) {
        String browser = "";

        if (userAgent.indexOf("Trident/7.0") > -1) {
            browser = "ie11";
        }
        else if (userAgent.indexOf("MSIE 10") > -1) {
            browser = "ie10";
        }
        else if (userAgent.indexOf("MSIE 9") > -1) {
            browser = "ie9";
        }
        else if (userAgent.indexOf("MSIE 8") > -1) {
            browser = "ie8";
        }
        else if (userAgent.indexOf("Chrome/") > -1) {
            browser = "Chrome";
        }
        else if (userAgent.indexOf("Chrome/") == -1 && userAgent.indexOf("Safari/") >= -1) {
            browser = "Safari";
        }
        else if (userAgent.indexOf("Firefox/") >= -1) {
            browser = "Firefox";
        }
        else {
            browser ="Other";
        }
        return browser;
    }
}
