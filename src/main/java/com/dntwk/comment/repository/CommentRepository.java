package com.dntwk.comment.repository;

import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
