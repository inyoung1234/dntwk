package com.dntwk.comment.dto;

import com.dntwk.comment.entity.Comment;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long commentIdx;
    private String commentUserNickname;
    private String commentUserEmail;
    private String commentContent;
    private boolean commentHide;
    private Long commentSuperCommentIdx;
    private String commentGrade;
    private Date createDt;

    public CommentDTO deleteContent(){
        this.commentContent="";
        return this;
    }
}
