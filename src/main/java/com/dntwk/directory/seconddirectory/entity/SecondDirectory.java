package com.dntwk.directory.seconddirectory.entity;

import com.dntwk.comm.BaseEntity;
import com.dntwk.directory.firstdirectory.entity.FirstDirectory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class SecondDirectory extends BaseEntity {

    @Id
    private String secondDirectoryName;

    @Column
    private Byte secondDirectorySortNum;

    @ManyToOne
    @JoinColumn
    private FirstDirectory secondDirectory;

    public void setsecondDirectory(FirstDirectory secondDirectory){
        if(secondDirectory!=null){
            this.getSecondDirectory().getSecondDirectoryList().remove(this);
        }
        this.secondDirectory =secondDirectory;
        getSecondDirectory().getSecondDirectoryList().add(this);
    }
}
