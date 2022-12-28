package com.dntwk.category.controller;

import com.dntwk.category.dto.CreateCategoryDTO;
import com.dntwk.category.dto.ModifyCategoryDTO;
import com.dntwk.category.dto.RequestCategoryDTO;
import com.dntwk.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PutMapping("/categories")
    public void modifyCategory(ServletRequest servletRequest, @RequestBody RequestCategoryDTO requestCategoryDTO){
        for(CreateCategoryDTO createCategoryDTO : requestCategoryDTO.getCreateCategoryDTOList()){
            createCategoryDTO.setCreateIp((String) servletRequest.getAttribute("userIp"));
            categoryService.createCategory(createCategoryDTO);
        }
        for(ModifyCategoryDTO modifyCategoryDTO : requestCategoryDTO.getModifyCategoryDTOList()){
            modifyCategoryDTO.setModIp((String) servletRequest.getAttribute("userIp"));
        }
        categoryService.modifyCategoryCommender(requestCategoryDTO.getModifyCategoryDTOList());
    }
}
