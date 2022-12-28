package com.dntwk.post.service;

import com.dntwk.category.entity.Category;
import com.dntwk.post.DTO.CreatePostDTO;
import com.dntwk.post.DTO.OnePostDTO;
import com.dntwk.post.DTO.PostListDTO;
import com.dntwk.post.entity.Post;
import com.dntwk.post.repository.PostRepository;
import com.dntwk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public OnePostDTO getPost(Long postIdx){
        Post post = postRepository.findById(postIdx).orElseGet(Post::new);
        return new OnePostDTO().dtoBuilder(post);
    }

    public OnePostDTO createPost(CreatePostDTO postDTO){
        Post CreatePost = Post.builder()
                .createDt(new Date())
                .createId(postDTO.getCreateId())
                .createIp(postDTO.getCreateIp())
                .postCategory(Category.builder().categoryIdx(postDTO.getPostCategory()).build())
                .postName(postDTO.getPostName())
                .postContents(postDTO.getPostContents())
                //jwt로 검증 해서 null값이 있을리가 없음
                .postUser(userRepository.findByUserId(postDTO.getCreateId()).get())
                .build();
        Post post = postRepository.save(CreatePost);
        return new OnePostDTO().dtoBuilder(post);
    }

    public void deletePost(Long postIdx){
        postRepository.deleteById(postIdx);
    }

    public List<PostListDTO> AllPostList(Pageable pageAble){
        return postRepository.findAllByPostCategoryNotNullOrderByPostIdxDesc(pageAble).map(e->new PostListDTO().dtoBuilder(e)).toList();
    }

    public List<PostListDTO> PostList(Long categoryIdx,Pageable pageAble){
        return postRepository.findByPostCategory(Category.builder().categoryIdx(categoryIdx).build(),pageAble)
                .map(e->new PostListDTO().dtoBuilder(e)).toList();
    }

    public List<PostListDTO> getRelateList(Long postIdx,Pageable pageable){
        Category category = postRepository.findById(postIdx).get().getPostCategory();

        return postRepository.findAllByPostCategoryOrderByPostIdxDesc(category,pageable)
                .map(e->new PostListDTO().dtoBuilder(e))
                .toList();
    }
}