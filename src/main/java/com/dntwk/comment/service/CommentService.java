package com.dntwk.comment.service;

import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.dto.CreateCommentDTO;
import com.dntwk.comment.entity.Comment;
import com.dntwk.comment.repository.CommentRepository;
import com.dntwk.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentDTO> getCommentList(Long postIdx){
        return commentRepository.findAllByCommentPost(Post.builder().postIdx(postIdx).build()).stream().map(e-> new CommentDTO().entityToDTO(e)).collect(Collectors.toList());
    }

    public List<CommentDTO> createComment(CreateCommentDTO createCommentDTO){
        //연타방지
        if(commentRepository.findByCreateDtIsGreaterThanAndCreateIp(new Date(createCommentDTO.getCreateDt().getTime()-10000),
                createCommentDTO.getCreateIp())!=null){
            return getCommentList(createCommentDTO.getCommentPost());
        };

        commentRepository.save(createCommentDTO.toEntity());
        return getCommentList(createCommentDTO.getCommentPost());
    }
}
