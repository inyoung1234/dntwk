package com.dntwk.comm;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class DTOToEntity<T> {

    private Class<T> target;
    private List<Field> fields;

    public DTOToEntity() {
        System.out.println("변환기 실행");
    }

    public void dtoDTO(){
        fields = new ArrayList<>();
        fields.addAll(Arrays.asList(target.getDeclaredFields()));
        for(Field tfield : fields){
            System.out.println(tfield);
        }
    }
}
