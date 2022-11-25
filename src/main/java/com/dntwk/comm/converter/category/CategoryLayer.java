package com.dntwk.comm.converter.category;

import com.dntwk.comm.converter.ConverterCommonType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryLayer implements ConverterCommonType {
    FIRST("1","FIRST"),SECOND("2","SECOND");

    private final String dbcode;
    private final String desc;

    @Override
    public String getdbcode() {
        return this.dbcode;
    }

    @Override
    public String getdesc() {
        return this.desc;
    }
}
