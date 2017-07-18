package com.yong.jpa.product;

import com.yong.jpa.category.Category;
import com.yong.jpa.common.Register;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by lichking on 2017. 7. 13..
 */
@Entity
@Data
public class Product extends Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
