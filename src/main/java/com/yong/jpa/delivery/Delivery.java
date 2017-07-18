package com.yong.jpa.delivery;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by lichking on 2017. 7. 18..
 */
@Data
@Entity
public class Delivery {
    @Id
    @Column(name = "delivery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    public Delivery(){
        this.deliveryStatus = DeliveryStatus.READY;
    }
}
