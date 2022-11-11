package com.dntwk.comm.converter.usergrade;

import com.dntwk.comm.converter.AbstractDbcodeEnumAttributeConverter;

import javax.persistence.Converter;

@Converter
public class UserGradeAttributeConverter extends AbstractDbcodeEnumAttributeConverter<UserGrade> {
    private static final String enumName = "사용자 등급";
    public UserGradeAttributeConverter(){
        super(UserGrade.class,false,enumName);
    }
}
