package com.dntwk.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SubSortedCategoryDTO {
    private String categoryName;
    private String superCategoryName;
}
