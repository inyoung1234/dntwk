package com.dntwk.category.dto;

import com.dntwk.category.entity.Category;
import com.dntwk.comm.converter.category.CategoryLayer;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDTO {
    private String categoryName;
    private CategoryLayer categoryLayer;
    private String superCategoryName="none";
    @Setter
    private Integer categorySortedNum;
    private Date createDt;
    private String createId;
    @Setter
    private String createIp;
    public Category toEntity(){
        return Category.builder()
                .categoryName(categoryName)
                .categoryLayer(categoryLayer)
                .superCategoryName(superCategoryName)
                .categorySortedNum(categorySortedNum)
                .createDt(new Date())
                .createId(createId)
                .createIp(createIp)
                .build();
    }
}