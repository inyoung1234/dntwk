package com.dntwk.directory.entity;

import com.dntwk.comm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Directory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="directory_idx")
    private Long directoryIdx;

    @Column(name="super_directory")
    private Integer superDirectory;

    @Column(name="directory_name")
    private String directoryName;

    @Column(name="directory_sort_num")
    private Byte directorySortNum;
}
