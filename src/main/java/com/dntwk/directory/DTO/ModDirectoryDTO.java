package com.dntwk.directory.DTO;

import com.dntwk.directory.firstdirectory.entity.FirstDirectory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ModDirectoryDTO {

    private Integer superDirectory;

    private String directoryName;

    private Byte directorySortNum;

    private Date modDt;

    private String modId;

    private String modIp;

    public FirstDirectory toEntity(){
        return FirstDirectory.builder()
                .directorySortNum(directorySortNum)
                .directoryName(directoryName)
                .superDirectory(superDirectory)
                .modDt(modDt)
                .modId(modId)
                .modIp(modIp)
                .build();
    }
}
