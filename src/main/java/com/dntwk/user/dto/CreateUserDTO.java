package com.dntwk.user.dto;


import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.user.entity.Authority;
import com.dntwk.user.entity.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateUserDTO {
    private Long userIdx;

    private String userId;

    private String userPwd;

    private String userNickname;

    private Date createDt;

    @Setter
    private String createIp;

    public User toEntity(PasswordEncoder passwordEncoder, Set<Authority> authorities){
        return User.builder()
                .userId(userId)
                .userPwd(passwordEncoder.encode(userPwd))
                .userNickname(userNickname)
                .userAuthorities(authorities)
                .createDt(new Date())
                .createIp(createIp)
                .build();
    }
}
