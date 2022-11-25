package com.dntwk;

import com.dntwk.category.dto.CreateCategoryDTO;
import com.dntwk.category.service.CategoryService;
import com.dntwk.comm.converter.category.CategoryLayer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {

    private final CategoryService categoryService;

    @GetMapping("/")
    public String main(){
//        categoryService.createCategory(CreateCategoryDTO.builder().categoryLayer(CategoryLayer.FIRST).categoryName("1")
//                .superCategoryName("none").build());
    return "main";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin/admin-directory";
    }
}
