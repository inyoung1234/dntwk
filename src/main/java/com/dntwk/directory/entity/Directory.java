package com.dntwk.directory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="directory_idx")
    private Long directoryIdx;

    @Column(name="directory_name")
    private String directorySubName;

    @Column(name="directory_sort_num")
    private int directorySubSortNum;

    @Column(name="create_dt")
    private Date createDt;

    @Column(name="create_id")
    private Date createId;

    @Column(name="create_ip")
    private Date createIp;

    @Column(name="mod_dt")
    private Date modDt;

    @Column(name="mod_id")
    private Date modId;

    @Column(name="mod_ip")
    private Date modIp;

    @Column(name="mod_descript")
    private Date modDescript;

}
