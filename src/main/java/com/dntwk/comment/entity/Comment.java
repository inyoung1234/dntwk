package com.dntwk.comment.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.post.entity.Post;
import com.dntwk.user.entity.User;
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
    @Column(name = "comment_idx")
    private Long commentIdx;

    @JoinColumn(name = "comment_post_idx")
    @ManyToOne
    private Post commentPost;

    public void setCommentPost(Post commentPost) {
        if (this.commentPost != null) {
            this.commentPost.getCommentList().remove(this);
        }
        this.commentPost = commentPost;
        getCommentPost().getCommentList().add(this);
    }

    @JoinColumn(name = "comment_user")
    @ManyToOne
    private User commentUser;

    public void setCommentUser(User commentUser) {
        if (this.commentUser != null) {
            this.commentUser.getCommentList().remove(this);
        }
        this.commentUser = commentUser;
        getCommentUser().getCommentList().add(this);

    }

    @Column
    private String commentUserIdx;

    @Column
    private String commentUserNickname;

    @Column
    private String commentContent;

    @Column
    private boolean commentHide;

    @Column
    private Long commentSuperCommentIdx;

    @Column
    private String commentGrade;
}
