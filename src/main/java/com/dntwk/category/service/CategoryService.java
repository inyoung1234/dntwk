package com.dntwk.category.service;

import com.dntwk.category.dto.CreateCategoryDTO;
import com.dntwk.category.dto.ModifyCategoryDTO;
import com.dntwk.category.dto.SortedCategoryDTO;
import com.dntwk.category.dto.SubSortedCategoryDTO;
import com.dntwk.category.entity.Category;
import com.dntwk.category.repository.CategoryRepository;
import com.dntwk.comm.converter.category.CategoryLayer;
import com.dntwk.comm.exception.NotFoundSuchColumnException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final EntityManager em;

    @Transactional
    public void modifyCategoryCommender(Queue<ModifyCategoryDTO> modifyCategoryDTOQueue) {
        for(ModifyCategoryDTO modifyCategoryDTO : modifyCategoryDTOQueue){
            switch (modifyCategoryDTO.getPostRequestIdentifier()){
                case NAME: modifyCategoryName(modifyCategoryDTO); break;
                case LAYER: modifyCategoryLayerAndSort(modifyCategoryDTO); break;
                case SORT: modifyCategorySort(modifyCategoryDTO);
            }
        }
    }

    public List<SortedCategoryDTO> getCategoryList(){
        List<SortedCategoryDTO> sortedCategoryDTOList = new ArrayList<>();
        List<Category> EntityList = categoryRepository.findAllByCategoryLayerOrderByCategorySortedNum(CategoryLayer.FIRST);
        for (Category category : EntityList) {
            SortedCategoryDTO sortedCategoryDTO = new SortedCategoryDTO();
            sortedCategoryDTO.setCategoryName(category.getCategoryName());
            sortedCategoryDTOList.add(sortedCategoryDTO);
        }
        TypedQuery<SubSortedCategoryDTO> query = em.createQuery("select new com.dntwk.category.dto.SubSortedCategoryDTO(d.categoryName,c.categoryName) from Category c join Category d " +
                "on c.categoryLayer = :layer and c.categoryName = d.superCategoryName " +
                "order by c.categorySortedNum,d.categorySortedNum", SubSortedCategoryDTO.class);
        query.setParameter("layer",CategoryLayer.FIRST);
        List<SubSortedCategoryDTO> subSortedCategoryDTOList = query.getResultList();
        for (SortedCategoryDTO sortedCategoryDTO : sortedCategoryDTOList) {
            sortedCategoryDTO.setSubCategoryList(new ArrayList<>());
            for (SubSortedCategoryDTO subSortedCategoryDTO : subSortedCategoryDTOList) {
                if (sortedCategoryDTO.getCategoryName().equals(subSortedCategoryDTO.getSuperCategoryName())) {
                    sortedCategoryDTO.getSubCategoryList().add(subSortedCategoryDTO);
                }
            }
        }
        return sortedCategoryDTOList;
    }

    public void createCategory(CreateCategoryDTO createCategoryDTO) {
        Integer countColumn = categoryRepository.countBySuperCategoryName("none");
        createCategoryDTO.setCategorySortedNum(countColumn+1);
        categoryRepository.findByCategoryNameAndCategoryLayer(createCategoryDTO.getCategoryName(), createCategoryDTO.getCategoryLayer())
                .orElseGet(() -> categoryRepository.save(createCategoryDTO.toEntity()));
    }

    public void modifyCategoryName(ModifyCategoryDTO modifyCategoryDTO) {
        categoryRepository.findByCategoryNameAndSuperCategoryName(modifyCategoryDTO.getModCategoryName(), modifyCategoryDTO.getSuperCategoryName())
                .ifPresentOrElse(x -> x.modCategoryName(modifyCategoryDTO.getCategoryName()), () -> {
                    throw new NotFoundSuchColumnException();
                });
    }

    public void modifyCategorySort(ModifyCategoryDTO modifyCategoryDTO) {
        List<Category> categoryList = categoryRepository.findAllBySuperCategoryName(modifyCategoryDTO.getSuperCategoryName());
        if (categoryList.size() > 0) {
            categoryList.stream().filter(category -> category.getCategorySortedNum() < modifyCategoryDTO.getModCategorySortedNum())
                    .filter(category -> category.getCategorySortedNum() >= modifyCategoryDTO.getModCategorySortedNum())
                    .forEach(category -> category.modCategorySortedNum(category.getCategorySortedNum() + 1));
            categoryList.stream().filter(category -> category.getCategoryName().equals(modifyCategoryDTO.getCategoryName()))
                    .findAny()
                    .ifPresentOrElse(category -> category.modCategorySortedNum(modifyCategoryDTO.getModCategorySortedNum()),
                            () -> {
                                throw new NotFoundSuchColumnException();
                            });
        } else {
            throw new NotFoundSuchColumnException();
        }
    }

    public void modifyCategoryLayerAndSort(ModifyCategoryDTO modifyCategoryDTO) {
        List<Category> modCategoryList = categoryRepository.findAllBySuperCategoryName(modifyCategoryDTO.getModSuperCategoryName());
        modCategoryList.stream().filter(category -> category.getCategorySortedNum() >= modifyCategoryDTO.getModCategorySortedNum())
                .forEach(category -> category.modCategorySortedNum(category.getCategorySortedNum() + 1));
        List<Category> categoryList = categoryRepository.findAllBySuperCategoryName(modifyCategoryDTO.getSuperCategoryName());
        categoryList.stream().filter(category -> category.getCategorySortedNum() >= modifyCategoryDTO.getCategorySortedNum())
                .forEach(category -> category.modCategorySortedNum(category.getCategorySortedNum() - 1));
        categoryList.stream().filter(category -> category.getCategoryName().equals(modifyCategoryDTO.getCategoryName()))
                .findAny()
                .ifPresentOrElse(category -> {
                    category.modCategorySortedNum(modifyCategoryDTO.getModCategorySortedNum());
                    category.modSuperCategoryName(modifyCategoryDTO.getSuperCategoryName());
                    if (modifyCategoryDTO.getCategoryLayer() != modifyCategoryDTO.getCategoryLayer()) {
                        category.modCategoryLayer(modifyCategoryDTO.getModCategoryLayer());
                    }
                }, () -> {
                    throw new NotFoundSuchColumnException();
                });
    }
}
