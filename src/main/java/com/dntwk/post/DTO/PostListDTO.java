package com.dntwk.post.DTO;

import com.dntwk.post.entity.Post;
import lombok.*;

import java.util.Date;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostListDTO {
    private Long postIdx;
    private String postUser;
    private String postName;
    private String postCategory;
    private Date createDt;

    public PostListDTO dtoBuilder(Post post){
        this.postCategory = post.getPostCategory().getCategoryName();
        this.postIdx=post.getPostIdx();
        this.postName=post.getPostName();
        this.postUser=post.getPostUser().getUserNickname();
        this.createDt=post.getCreateDt();
        return this;
    }
}
