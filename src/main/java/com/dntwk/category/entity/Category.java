package com.dntwk.category.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.comm.converter.category.CategoryLayer;
import com.dntwk.comm.converter.category.CategoryLayerAttributeConverter;
import com.dntwk.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class Category extends BaseEntity {
    //카테고리의 레이어 이동을 허락하기 위해 등급을 표시하고 엔티티을 합쳤다.
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryIdx;

    @Column(nullable = false)
    private String categoryName;

    @Convert(converter= CategoryLayerAttributeConverter.class)
    @Column(nullable = false)
    private CategoryLayer categoryLayer;

    @Column(nullable = false)
    private String superCategoryName;

    @Column(nullable = false)
    private Integer categorySortedNum;

    @OneToMany(mappedBy = "postCategory")
    private List<Post> postList = new ArrayList<>();

    public void modCategoryName(String categoryName){
        this.categoryName=categoryName;
    }

    public void modCategorySortedNum(Integer categorySortedNum){
        this.categorySortedNum=categorySortedNum;
    }

    public void modSuperCategoryName(String superCategoryName){
        this.superCategoryName=superCategoryName;
    }

    public void modCategoryLayer(CategoryLayer categoryLayer){
        this.categoryLayer=categoryLayer;
    }
}
