package com.dntwk.post.repository;

import com.dntwk.category.entity.Category;
import com.dntwk.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findAllByPostCategoryNotNullOrderByPostIdxDesc(Pageable pageable);
    Page<Post> findAllByPostCategoryOrderByPostIdxDesc(Category category,Pageable pageable);

    Page<Post> findByPostCategory(Category category,Pageable pageable);

}