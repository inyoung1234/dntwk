package com.dntwk.post.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.comment.entity.Comment;
import com.dntwk.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postIdx;

    @JoinColumn(name="post_user")
    @ManyToOne
    private User postUser;

    public void setPostUser(User postUser){
        if(postUser!=null){
            this.getPostUser().getPostList().remove(this);
        }
        this.postUser=postUser;
        getPostUser().getPostList().add(this);
    }

    @OneToMany(mappedBy = "commentPost")
    private List<Comment> commentList = new ArrayList<Comment>();

    @Column
    private String postName;

    @Lob
    private Blob postContent;
}
