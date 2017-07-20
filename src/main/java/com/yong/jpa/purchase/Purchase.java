package com.yong.jpa.purchase;

import com.yong.jpa.common.Register;
import com.yong.jpa.delivery.Delivery;
import com.yong.jpa.member.Member;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 13..
 */
@Entity
@Data
public class Purchase extends Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id")
    private List<PurchaseDetail> purchaseDetails;

    @OneToOne(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Delivery delivery;

    @Column(name = "purchase_status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_datetime")
    private Calendar purchaseDatetime;

    public Purchase(){
        this.purchaseStatus = PurchaseStatus.ORDER;
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        this.delivery.setPurchase(this);
    }
}
