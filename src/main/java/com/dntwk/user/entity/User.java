package com.dntwk.user.entity;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_idx")
    private Long userIdx;

    @Column(name="user_id", unique = true)
    private String userId;

    @Column(name="user_pwd")
    private String userPwd;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_nickname")
    private String userNickname;

    @Convert(converter= UserGradeAttributeConverter.class)
    @Column(name="user_grade")
    private UserGrade userGrade;

    @Column(name="create_dt")
    private Date createDt;

    @Column(name="create_id")
    private Date createId;

    @Column(name="create_ip")
    private Date createIp;

    @Column(name="mod_dt")
    private Date modDt;

    @Column(name="mod_id")
    private Date modId;

    @Column(name="mod_ip")
    private Date modIp;

    @Column(name="mod_descript")
    private Date modDescript;

}
