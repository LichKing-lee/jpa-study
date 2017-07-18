package com.yong.jpa.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lichking on 2017. 7. 18..
 */
@AllArgsConstructor
@Getter
public enum DeliveryStatus {
    READY("배송준비"), DELIVERING("배송중"), COMPLETE("배송완료");

    private final String description;
}
