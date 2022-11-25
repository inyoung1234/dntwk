package com.dntwk.category.dto;

import com.dntwk.comm.PostRequestIdentifier;
import com.dntwk.comm.converter.category.CategoryLayer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
public class ModifyCategoryDTO {
    private PostRequestIdentifier postRequestIdentifier;
    private String categoryName;
    private CategoryLayer categoryLayer;
    private String superCategoryName;
    private Integer categorySortedNum;
    private String modCategoryName;
    private CategoryLayer modCategoryLayer;
    private String modSuperCategoryName;
    private Integer modCategorySortedNum;
    private Date modDt;
    private String modId;
    @Setter
    private String modIp;
}
