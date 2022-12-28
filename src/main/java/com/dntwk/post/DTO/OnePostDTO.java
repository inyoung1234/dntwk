package com.dntwk.post.DTO;

import com.dntwk.post.entity.Post;
import lombok.*;

import java.util.Date;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OnePostDTO {
    private Long postIdx;

    private String postUser;

    private String postName;

    private String postContents;

    private String postCategory;

    private Date createDt;

    public OnePostDTO dtoBuilder(Post post){
        this.postCategory = post.getPostCategory().getCategoryName();
        this.postIdx=post.getPostIdx();
        this.postContents=post.getPostContents();
        this.postName=post.getPostName();
        this.postUser=post.getPostUser().getUserNickname();
        this.createDt=post.getCreateDt();
        return this;
    }
}