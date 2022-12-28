package com.dntwk.comment.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.post.entity.Post;
import com.dntwk.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;

    @JsonIgnore
    @JoinColumn(name = "comment_post_idx")
    @ManyToOne
    private Post commentPost;

    private String commentContent;

    private boolean commentHide;

    private boolean commentDeleted;

    private Long commentSuperCommentIdx;

    private String commentGrade;

    @JsonIgnore
    @JoinColumn(name = "comment_user")
    @ManyToOne
    private User commentUser;


    public void setCommentPost(Post commentPost) {
        if (this.commentPost != null) {
            this.commentPost.getCommentList().remove(this);
        }
        this.commentPost = commentPost;
        getCommentPost().getCommentList().add(this);
    }

    public void setCommentUser(User commentUser) {
        if (this.commentUser != null) {
            this.commentUser.getCommentList().remove(this);
        }
        this.commentUser = commentUser;
        getCommentUser().getCommentList().add(this);
    }
}
