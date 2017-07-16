package com.yong.jpa.purchase;

import com.yong.jpa.common.Register;
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

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "purchase_detail",
//            joinColumns = @JoinColumn(name = "purchase_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "purchase_id")
    private List<PurchaseDetail> purchaseDetails;

    @Column(name = "purchase_status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus purchaseStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_datetime")
    private Calendar purchaseDatetime;
}
