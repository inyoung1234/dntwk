package com.dntwk.comm.converter.usergrade;

import com.dntwk.comm.converter.ConverterCommonType;
import lombok.Getter;

@Getter
public enum UserGrade implements ConverterCommonType {

    GUEST("1","GUEST"),
    USER("2","USER"),
    SUPERUSER("3","SUPERUSER"),
    ADMIN("4","ADMIN");

    private String dbcode;
    private String desc;

    UserGrade(String dbcode,String desc){this.desc=desc; this.dbcode =dbcode;}

    @Override
    public String getdbcode() {
        return this.dbcode;
    }

    @Override
    public String getdesc() {
        return this.desc;
    }
}
