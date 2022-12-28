package com.dntwk.comment.dto;

import com.dntwk.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long commentIdx;
    private String commentUserNickname;
    private String commentContent;
    private boolean commentHide;
    private Long commentSuperCommentIdx;
    private String commentGrade;
    private Date createDt;

    public CommentDTO entityToDTO(Comment comment){
        this.commentIdx = comment.getCommentIdx();
        this.commentUserNickname= comment.getCommentUser().getUserNickname();
        this.commentContent= comment.getCommentContent();
        this.commentHide=comment.isCommentHide();
        this.commentSuperCommentIdx= comment.getCommentSuperCommentIdx();
        this.commentGrade= comment.getCommentGrade();
        this.createDt= comment.getCreateDt();
        return this;
    }

}
