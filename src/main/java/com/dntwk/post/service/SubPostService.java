package com.dntwk.post.service;

import com.dntwk.directory.entity.Directory;
import com.dntwk.post.DTO.CreatePostDTO;
import com.dntwk.post.DTO.OnePostDTO;
import com.dntwk.post.entity.Post;
import com.dntwk.post.repository.PostRepository;
import com.dntwk.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Transactional
@RequiredArgsConstructor
@Service
public class SubPostService {

    private final PostRepository postRepository;

    public OnePostDTO getPost(Long postIdx) {
        Post post = postRepository.findById(postIdx).orElseGet(Post::new);
        return OnePostDTO.builder().build().dtoBuilder(post);
    }

    public OnePostDTO createPost(CreatePostDTO postDTO) {
        Post CreatePost = Post.builder()
                .createDt(new Date())
                .createId(postDTO.getCreateId())
                .createIp(postDTO.getCreateIp())
                .postDirectory(Directory.builder().directoryIdx(postDTO.getPostDirectory()).build())
                .postName(postDTO.getPostName())
                .postContents(postDTO.getPostContents())
                .postUser(User.builder().userIdx(postDTO.getPostUser()).build())
                .build();
        Post post = postRepository.save(CreatePost);
        return OnePostDTO.builder().build().dtoBuilder(post);
    }
}