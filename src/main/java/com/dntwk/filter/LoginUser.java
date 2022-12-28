package com.dntwk.filter;

import com.dntwk.comm.converter.usergrade.UserGrade;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class LoginUser {
    private String UserEmail;
    private List<UserGrade> userGrade;
}
