package com.dntwk.directory.firstdirectory.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.directory.seconddirectory.entity.SecondDirectory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class FirstDirectory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long firstDirectoryName;

    @OneToMany(mappedBy = "secondDirectory")
    private List<SecondDirectory> secondDirectoryList = new ArrayList<>();

    @Column
    private Byte firstDirectorySortNum;

}
