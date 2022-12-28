package com.dntwk.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SubSortedCategoryDTO {
    private Long categoryIdx;
    private String categoryName;
    private String superCategoryName;
}
