package com.dntwk.post.controller;

import com.dntwk.category.service.CategoryService;
import com.dntwk.comm.ApiStatus;
import com.dntwk.comment.service.CommentService;
import com.dntwk.post.DTO.CreatePostDTO;
import com.dntwk.post.DTO.OnePostDTO;
import com.dntwk.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final CategoryService categoryService;
    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/")
    public ModelAndView main(Pageable pageAble, ModelAndView modelAndView) {
        modelAndView.setViewName("/main");
        modelAndView.addObject("postList", postService.AllPostList(pageAble));
        return modelAndView;
    }

    @GetMapping("/view/post-list/{value}")
    public ModelAndView returnPostList(@PathVariable String value, ModelAndView modelAndView, Pageable pageable) {
        modelAndView.addObject("postList",postService.PostList(Long.parseLong(value), pageable));
        modelAndView.setViewName("/main");
        return modelAndView;
    }

    @GetMapping("/view/post/{value}")
    public ModelAndView returnPostOne(@PathVariable("value") Long postIdx, ModelAndView modelAndView, Pageable pageable) {
        modelAndView.addObject("commentList", commentService.getCommentList(postIdx));
        modelAndView.addObject("postContents", postService.getPost(postIdx));
        modelAndView.addObject("relatedPostList", postService.getRelateList(postIdx, pageable));
        modelAndView.setViewName("/post/postView");
        return modelAndView;
    }

    @PostMapping("/post")
    public ApiStatus createPost(@RequestBody CreatePostDTO createPostDTO) {
        postService.createPost(createPostDTO);
        return ApiStatus.SUCCESS;
    }


    @GetMapping("/post/write")
    public ModelAndView writePage(ModelAndView modelAndView) {
        modelAndView.setViewName("/post/write");
        modelAndView.addObject("CategoryListWithIdx", categoryService.getCategoryListWithIdx());
        return modelAndView;
    }
}
