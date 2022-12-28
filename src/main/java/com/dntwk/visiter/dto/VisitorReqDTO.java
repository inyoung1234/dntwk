package com.dntwk.visiter.dto;

import com.dntwk.visiter.Visitor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class VisitorReqDTO {
    private Long visitId;
    private String visitIp;
    private String userId;
    private String visitRefer;

    public Visitor toEntity(){
        return Visitor.builder()
                .visitId(visitId)
                .visitIp(visitIp)
                .userId(userId)
                .visitRefer(visitRefer)
                .visitTime(new Date())
                .build();
    }
}
