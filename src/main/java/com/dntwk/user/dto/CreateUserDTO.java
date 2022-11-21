package com.dntwk.user.dto;


import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Builder
public class CreateUserDTO {
    private Long userIdx;

    private String userId;

    private String userPwd;

    private String userNickname;

    private UserGrade userGrade;

    private Date createDt;

    private String createId;

    @Setter
    private String createIp;

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .userPwd(this.userPwd)
                .userNickname(this.userNickname)
                .userGrade(this.userGrade)
                .createDt(new Date())
                .createId(this.userId)
                .createIp(createIp)
                .build();
    }
}
