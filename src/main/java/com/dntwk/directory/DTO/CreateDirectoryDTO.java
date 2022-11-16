package com.dntwk.directory.DTO;

import com.dntwk.comm.DTOToEntity;
import com.dntwk.directory.entity.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class CreateDirectoryDTO extends DTOToEntity<Directory> {

    private DTOToEntity<Directory> directoryDTOToEntity;

    public CreateDirectoryDTO(){
        super.setTarget(Directory.class);
        super.dtoDTO();
    }

    private Integer superDirectory;

    private String directoryName;

    private Byte directorySortNum;

    public Directory toEntity(){
        Directory directory = Directory.builder()
                .superDirectory(this.superDirectory)
                .directoryName(this.directoryName)
                .directorySortNum(this.directorySortNum)
                .build();
        return directory;
    }
}
