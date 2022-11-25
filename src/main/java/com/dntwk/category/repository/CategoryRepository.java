package com.dntwk.category.repository;

import com.dntwk.category.entity.Category;
import com.dntwk.comm.converter.category.CategoryLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByCategoryNameAndCategoryLayer(String categoryName, CategoryLayer categoryLayer);
    Optional<Category> findByCategoryNameAndSuperCategoryName(String categoryName,String superCategoryName);
    Integer countBySuperCategoryName(String superCategoryName);
    List<Category> findAllBySuperCategoryName(String superCategoryName);
    List<Category> findAllByCategoryLayerOrderByCategorySortedNum(CategoryLayer categoryLayer);
}
