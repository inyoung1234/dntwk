package com.dntwk.comm.converter.category;

import com.dntwk.comm.converter.AbstractDbcodeEnumAttributeConverter;
import com.dntwk.comm.converter.usergrade.UserGrade;

import javax.persistence.Converter;

@Converter
public class CategoryLayerAttributeConverter extends AbstractDbcodeEnumAttributeConverter<CategoryLayer> {
    private static final String enumName = "카테고리 등급";
    public CategoryLayerAttributeConverter(){
        super(CategoryLayer.class,false,enumName);
    }
}
