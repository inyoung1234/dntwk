package com.dntwk.comment.service;

import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubCommentService {
    private final CommentRepository commentRepository;
    private final EntityManagerFactory entityManagerFactory;

    public List<CommentDTO> getCommentList(Long postIdx){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        TypedQuery<CommentDTO> query =
                em.createQuery("Select new com.dntwk.comment.dto.CommentDTO(c.commentIdx,c.commentUser.userNickname,c.commentContent,c.commentHide,c.commentSuperCommentIdx,c.commentGrade) " +
                        "FROM Comment c where c.commentPost=:postIdx", CommentDTO.class);
        query.setParameter("postIdx",postIdx);
        List<CommentDTO> list = query.getResultList();
        entityTransaction.commit();
        em.close();
        return list;
    }
}
