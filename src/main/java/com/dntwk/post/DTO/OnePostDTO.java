package com.dntwk.post.DTO;

import com.dntwk.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class OnePostDTO {
    private Long postIdx;

    private String postUser;

    private String postName;

    private String postContents;

    private Date createDt;

    public OnePostDTO dtoBuilder(Post post){
        this.postIdx=post.getPostIdx();
        this.postContents=post.getPostContents();
        this.postName=post.getPostName();
        this.postUser=post.getPostUser().getUserNickname();
        this.createDt=post.getCreateDt();
        return this;
    }
}