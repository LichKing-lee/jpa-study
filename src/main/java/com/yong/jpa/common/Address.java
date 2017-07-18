package com.yong.jpa.common;

import lombok.Data;

import javax.persistence.Column;

/**
 * Created by lichking on 2017. 7. 18..
 */
@Data
public class Address {
    @Column
    private String address;

    @Column(name = "address_detail")
    private String detail;

    @Column(name = "zip_code")
    private String zipCode;
}
