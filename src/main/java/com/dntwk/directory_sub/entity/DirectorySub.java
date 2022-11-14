package com.dntwk.directory_sub.entity;

import com.dntwk.directory.entity.Directory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class DirectorySub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="directory_sub_idx")
    private Long directorySubIdx;

    @OneToOne
    @JoinColumn(name="directory_idx")
    private Directory directory;

    @Column(name="directory_sub_name")
    private String directorySubName;

    @Column(name="directory_sub_sort_num")
    private int directorySubSortNum;

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

    @Column(name="mod_descript")
    private Date modDescript;
}
