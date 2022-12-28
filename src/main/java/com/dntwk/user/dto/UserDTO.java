package com.dntwk.user.dto;

import com.dntwk.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {
    private String userId;

    public static UserDTO of(User user) {
        return new UserDTO(user.getUserId());
    }
}
