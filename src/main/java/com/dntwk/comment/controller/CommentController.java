package com.dntwk.comment.controller;

import com.dntwk.comment.dto.CommentDTO;
import com.dntwk.comment.dto.CreateCommentDTO;
import com.dntwk.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{value}")
    public List<CommentDTO> createComment(CreateCommentDTO createCommentDTO, ServletRequest servletRequest){
        createCommentDTO.setCreateIp((String) servletRequest.getAttribute("userIp"));
        return commentService.createComment(createCommentDTO);
    }
}
