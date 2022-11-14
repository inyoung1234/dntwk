package com.dntwk.post.entity;

import com.dntwk.comment.entity.Comment;
import com.dntwk.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postIdx;

    @Setter
    @JoinColumn(name="post_user")
    @ManyToOne
    private User postUser;

    @OneToMany(mappedBy = "commentPost")
    private List<Comment> commentList = new ArrayList<Comment>();

    @Column
    private String postName;

    @Lob
    private Blob postContent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createIp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modDt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modIp;

}
