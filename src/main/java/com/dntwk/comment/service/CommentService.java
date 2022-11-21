package com.dntwk.comment.service;

import com.dntwk.comment.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {

    private final SubCommentService subCommentService;

    public List<CommentDTO> getCommentList(Long postIdx){
        return subCommentService.getCommentList(postIdx);
    }
}
