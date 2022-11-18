package com.dntwk.directory.dto;

import com.dntwk.directory.entity.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModDirectoryDTO {
    private Integer directoryLayer;

    private String directoryName;

    private String superDirectoryName;

    private Integer directorySortedNum;

    private Date modDt;

    private String modId;

    private String modIp;

    public Directory toEntity(){
        return Directory.builder()
                .directoryLayer(directoryLayer)
                .directoryName(directoryName)
                .directorySortedNum(directorySortedNum)
                .superDirectoryName(superDirectoryName)
                .modIp(modIp)
                .modId(modId)
                .modDt(modDt)
                .build();
    }
}
