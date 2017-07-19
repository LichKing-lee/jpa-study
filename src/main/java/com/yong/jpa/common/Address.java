package com.yong.jpa.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by lichking on 2017. 7. 18..
 */
@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Address {
    @NonNull
    @Column(nullable = false)
    private String address;

    @Column(name = "address_detail")
    private String detail;

    @Column(name = "zip_code")
    private String zipCode;
}
