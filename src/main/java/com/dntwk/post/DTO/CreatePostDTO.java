package com.dntwk.post.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class CreatePostDTO {

    private Long postIdx;

    private Long postUser;

    private Long postDirectory;

    private String postName;

    private String postContents;

    private Date createDt;

    private String createId;

    @Setter
    private String createIp;
}
