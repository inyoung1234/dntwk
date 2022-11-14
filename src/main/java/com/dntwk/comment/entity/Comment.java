package com.dntwk.comment.entity;

import com.dntwk.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_idx")
    private Long commentIdx;

    @Column
    private Long commentPostIdx;

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
    private String comment;

    @Column
    private String commentGrade;

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
