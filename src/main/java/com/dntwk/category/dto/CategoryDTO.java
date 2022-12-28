package com.dntwk.category.dto;

import com.dntwk.category.entity.Category;
import com.dntwk.comm.converter.category.CategoryLayer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    private Long categoryIdx;
    private String categoryName;

    public CategoryDTO(Category category){
        this.categoryIdx=category.getCategoryIdx();
        this.categoryName=category.getCategoryName();
    }
}
