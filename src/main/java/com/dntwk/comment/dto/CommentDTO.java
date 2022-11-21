package com.dntwk.comment.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {

    private Long commentIdx;

    private String commentUserNickname;

    private String commentContent;

    private boolean commentHide;

    private Long commentSuperCommentIdx;

    private String commentGrade;
}
