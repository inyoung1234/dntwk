package com.dntwk.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class RequestCategoryDTO {
    List<ModifyCategoryDTO> modifyCategoryDTOList;
    List<CreateCategoryDTO> createCategoryDTOList;
}
