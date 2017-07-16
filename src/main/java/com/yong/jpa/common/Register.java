package com.yong.jpa.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

/**
 * Created by lichking on 2017. 7. 13..
 */
@MappedSuperclass
public abstract class Register {
    @Column(name = "insert_username")
    private String insertUsername;

    @Column(name = "insert_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar insertDatetime;

    @Column(name = "modify_username")
    private String modifyUsername;

    @Column(name = "modify_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modifyDatetime;
}
