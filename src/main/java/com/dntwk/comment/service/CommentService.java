package com.dntwk.comment.service;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.dto.CreateCommentDTO;
import com.dntwk.comment.repository.CommentRepository;
import com.dntwk.filter.LoginUser;
import com.dntwk.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
    private final LoginUser loginUser;
    private final CommentRepository commentRepository;
    private final EntityManager entityManager;

    public List<CommentDTO> getCommentList(Long postIdx) {
        TypedQuery<CommentDTO> query = entityManager.createQuery("select new com.dntwk.comment.dto.CommentDTO" +
                "(c.commentIdx,u.userNickname,u.userId,c.commentContent,c.commentHide,c.commentSuperCommentIdx,c.commentGrade,c.createDt) " +
                "from Comment c join c.commentPost p join c.commentUser u on c.commentPost=:post " +
                "and p.postIdx = :postIdx and c.commentUser.userIdx=u.userIdx", CommentDTO.class);
        query.setParameter("post", Post.builder().postIdx(postIdx).build());
        query.setParameter("postIdx", postIdx);
        List<CommentDTO> lo =  query.getResultList();
        lo.forEach(el->{
            if((el.isCommentHide()&&!el.getCommentUserEmail().equals(loginUser.getUserEmail()))||!loginUser.getUserGrade().contains(UserGrade.ADMIN)){
                el.deleteContent();
            }
        });
        return query.getResultList();
    }

    public List<CommentDTO> createComment(CreateCommentDTO createCommentDTO) {
        //연타방지
        if (commentRepository.findByCreateDtIsGreaterThanAndCreateIp(new Date(createCommentDTO.getCreateDt().getTime() - 10000),
                createCommentDTO.getCreateIp()) != null) {
            return getCommentList(createCommentDTO.getCommentPost());
        }

        commentRepository.save(createCommentDTO.toEntity());
        return getCommentList(createCommentDTO.getCommentPost());
    }
}
