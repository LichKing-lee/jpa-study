package com.yong.jpa.product;

import com.yong.jpa.common.Register;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Created by lichking on 2017. 7. 13..
 */
@Entity
@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Product extends Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    @NonNull
    private String name;

    @Column(name = "product_price")
    @NonNull
    private int price;

//    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
//    private List<Purchase> purchases;
}
