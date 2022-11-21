package com.dntwk.post.service;

import com.dntwk.comm.ApiStatus;
import com.dntwk.post.DTO.CreatePostDTO;
import com.dntwk.post.DTO.OnePostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    private final SubPostService subPostService;

    public OnePostDTO getPost(Long postIdx){
        return subPostService.getPost(postIdx);
    }

    public OnePostDTO createPost(CreatePostDTO postDTO){
        return subPostService.createPost(postDTO);
    }
}