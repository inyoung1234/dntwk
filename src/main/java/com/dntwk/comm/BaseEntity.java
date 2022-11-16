package com.dntwk.comm;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@MappedSuperclass
public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @Column
    private String createId;

    @Column
    private String createIp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modDt;

    @Column
    private String modId;

    @Column
    private String modIp;
}