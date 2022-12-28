package com.dntwk.user.entity;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @Column(length = 50,name="authority_name")
    @Convert(converter= UserGradeAttributeConverter.class)
    private UserGrade authorityName;

    public String getAuthorityName() {
        return this.authorityName.toString();
    }
}