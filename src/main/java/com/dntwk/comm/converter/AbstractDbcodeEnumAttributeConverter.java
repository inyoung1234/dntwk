package com.dntwk.comm.converter;

import com.dntwk.comm.converter.usergrade.UserGrade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Getter
@Setter
@RequiredArgsConstructor
@Converter
public class AbstractDbcodeEnumAttributeConverter<E extends Enum<E> & ConverterCommonType> implements AttributeConverter<E, String> {

    private Class<E> targetEnumClass ;

    private Class<UserGrade> target2 = UserGrade.class;

    private boolean nullable;

    private String ENUM_NAME;

    public AbstractDbcodeEnumAttributeConverter(boolean b, String enumName) {
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if(!nullable&& attribute==null){
            throw new IllegalArgumentException(String.format("%s는 NULL로 저장 할 수 없습니다.", ENUM_NAME));
        }
        return EnumValueConvertUtils.toDbCode(attribute);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && dbData==null || dbData=="" || dbData.length()==0){
            throw new IllegalArgumentException(String.format("%s는 DB에 NULL 혹은 Empty로(%s) 저장 되어 있습니다.", ENUM_NAME,dbData));
        }
        System.out.println("타겟1 "+targetEnumClass);
        System.out.println("타겟2 " + target2);
        System.out.println("테스트0 " + UserGrade.class);
        return EnumValueConvertUtils.ofDbCode(targetEnumClass,dbData);
    }
}
