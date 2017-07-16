package com.yong.jpa.purchase;

import com.yong.jpa.common.Register;
import com.yong.jpa.product.Product;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by lichking on 2017. 7. 14..
 */
@Entity
@Table(name = "purchase_detail")
@Data
public class PurchaseDetail extends Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_detail_id")
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "purchase_count")
    private int count;

    public int getPrice(){
        return this.product.getPrice() * this.count;
    }
}
