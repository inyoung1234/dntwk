package com.dntwk.directory.DTO;

import com.dntwk.directory.firstdirectory.entity.FirstDirectory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CreateDirectoryDTO {
    private Integer superDirectory;

    private String directoryName;

    private Byte directorySortNum;

    private Date createDt;

    private String createId;

    private String createIp;

    public FirstDirectory toEntity(){
        return FirstDirectory.builder()
                .directorySortNum(directorySortNum)
                .directoryName(directoryName)
                .superDirectory(superDirectory)
                .createDt(createDt)
                .createId(createId)
                .createIp(createIp)
                .build();
    }
}
