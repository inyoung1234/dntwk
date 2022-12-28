package com.dntwk.user.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import com.dntwk.comment.entity.Comment;
import com.dntwk.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class User extends BaseEntity {

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name="user_idx",referencedColumnName = "user_idx")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "authority_name")}
    )
    private Set<Authority> userAuthorities = new HashSet<>();


    public String getAuthoritiesToString() {
        return this.getUserAuthorities().stream()
                .map(Authority::getAuthorityName)
                .collect(Collectors.joining(","));
    }

    public void addAuthority(Authority authority) {
        this.getUserAuthorities().add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.getUserAuthorities().remove(authority);
    }
}
