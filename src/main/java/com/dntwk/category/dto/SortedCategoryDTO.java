package com.dntwk.category.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SortedCategoryDTO {
    private String categoryName;
    private List<SubSortedCategoryDTO> subCategoryList;
}
