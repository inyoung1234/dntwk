package com.dntwk.directory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SortedDirectoryListDTO {
    private String directoryName;
    private Integer directoryLayer;
    private String superDirectoryName;
}
