package com.dntwk.jwt.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class RefreshToken {
    @Id
    private String userKey;

    @Column(nullable = false)
    private String token;

    public void updateToken(String token){
        this.token=token;
    }
}
