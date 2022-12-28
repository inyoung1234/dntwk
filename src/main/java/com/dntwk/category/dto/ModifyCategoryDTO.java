package com.dntwk.category.dto;

import com.dntwk.comm.PostRequestIdentifier;
import com.dntwk.comm.converter.category.CategoryLayer;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
