package com.dntwk.category.controller;

import com.dntwk.category.dto.CreateCategoryDTO;
import com.dntwk.category.dto.ModifyCategoryDTO;
import com.dntwk.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Queue;

@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PutMapping("/categories")
    public void modifyCategory(ServletRequest servletRequest, Queue<ModifyCategoryDTO> modifyCategoryDTOQueue, Queue<CreateCategoryDTO> createCategoryDTOQueue){
        for(CreateCategoryDTO createCategoryDTO : createCategoryDTOQueue){
            createCategoryDTO.setCreateIp((String) servletRequest.getAttribute("userIp"));
            categoryService.createCategory(createCategoryDTO);
        }
        for(ModifyCategoryDTO modifyCategoryDTO : modifyCategoryDTOQueue){
            modifyCategoryDTO.setModIp((String) servletRequest.getAttribute("userIp"));
        }
        categoryService.modifyCategoryCommender(modifyCategoryDTOQueue);
    }
}
