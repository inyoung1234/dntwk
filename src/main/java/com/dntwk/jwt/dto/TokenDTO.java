package com.dntwk.jwt.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenDTO {
    private String accessToken;
    private String refreshToken;
    private String grantType;
}
