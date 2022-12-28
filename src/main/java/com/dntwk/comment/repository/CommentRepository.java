package com.dntwk.comment.repository;

import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.entity.Comment;
import com.dntwk.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment findByCreateDtIsGreaterThanAndCreateIp(Date date,String createIp);
    List<Comment> findAllByCommentPost(Post post);
}
