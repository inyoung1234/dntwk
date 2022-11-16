package com.dntwk.directory.firstdirectory.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectoryDTO {
    private Integer superDirectory;

    private String directoryName;

    private Byte directorySortNum;

    private Date createDt;

    private String createId;

    private String createIp;

    private Date modDt;

    private String modId;

    private String modIp;
}
