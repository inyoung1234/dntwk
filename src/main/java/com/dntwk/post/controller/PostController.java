package com.dntwk.post.controller;

import com.dntwk.comment.service.CommentService;
import com.dntwk.post.DTO.CreatePostDTO;
import com.dntwk.post.DTO.OnePostDTO;
import com.dntwk.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final CommentService commentService;


    @GetMapping("/post/list/{value}")
    public void returnPostList(){

    }

    @GetMapping("/post/{value}")
    public ModelAndView returnPostOne(@PathVariable("value") Long postIdx, ModelAndView modelAndView){
        modelAndView.addObject("commentList",commentService.getCommentList(postIdx));
        modelAndView.addObject("postContents",postService.getPost(postIdx));
        return modelAndView;
    }

    @PostMapping("/post")
    public ModelAndView createPost(CreatePostDTO createPostDTO, ModelAndView modelAndView, ServletRequest servletRequest){
        createPostDTO.setCreateIp((String)servletRequest.getAttribute("userIp"));
        modelAndView.addObject("postContents",postService.createPost(createPostDTO));
        return modelAndView;
    }
}
