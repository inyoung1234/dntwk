package com.dntwk.comment.dto;

import com.dntwk.comment.entity.Comment;
import com.dntwk.post.entity.Post;
import com.dntwk.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Builder
public class CreateCommentDTO {

    private Long commentIdx;

    private Long commentPost;

    private Long commentUser;

    private String commentContent;

    private boolean commentHide;

    private Long commentSuperCommentIdx;

    private String commentGrade;

    private Date createDt;

    private String createId;

    @Setter
    private String createIp;

    public Comment toEntity(){
        return Comment.builder()
                .commentPost(Post.builder().postIdx(this.commentPost).build())
                .commentUser(User.builder().userIdx(this.commentUser).build())
                .commentContent(this.commentContent)
                .commentHide(this.commentHide)
                .commentSuperCommentIdx(this.commentSuperCommentIdx)
                .commentGrade(this.commentGrade)
                .createDt(new Date())
                .createId(this.createId)
                .createIp(this.createIp)
                .build();
    }

}
