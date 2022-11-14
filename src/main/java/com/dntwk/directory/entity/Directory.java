package com.dntwk.directory.entity;

import com.dntwk.directory_sub.entity.DirectorySub;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="directory_idx")
    private Long directoryIdx;

    @OneToMany(mappedBy = "directorySubDirectory")
    private List<DirectorySub> directorySubList = new ArrayList<DirectorySub>();

    @Column(name="directory_name")
    private String directoryName;

    @Column(name="directory_sort_num")
    private int directorySortNum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createIp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modDt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modIp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modDescript;


}
