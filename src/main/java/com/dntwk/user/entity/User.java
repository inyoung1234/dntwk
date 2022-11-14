package com.dntwk.user.entity;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import com.dntwk.comment.entity.Comment;
import com.dntwk.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_idx")
    private Long userIdx;

    @OneToMany(mappedBy = "commentUser")
    private List<Comment> commentList = new ArrayList<Comment>();

    @OneToMany(mappedBy = "postUser")
    private List<Post> postList = new ArrayList<Post>();

    @Column(name="user_id", unique = true)
    private String userId;

    @Column(name="user_pwd")
    private String userPwd;

    @Column(name="user_nickname")
    private String userNickname;

    @Convert(converter= UserGradeAttributeConverter.class)
    @Column(name="user_grade")
    private UserGrade userGrade;

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

    @Column(name="mod_descript")
    private Date modDescript;


}
