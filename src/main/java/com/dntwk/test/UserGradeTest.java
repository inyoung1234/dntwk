package com.dntwk.test;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;

import javax.persistence.*;


@Entity
public class UserGradeTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter= UserGradeAttributeConverter.class)
    private UserGrade userGrade;
}
