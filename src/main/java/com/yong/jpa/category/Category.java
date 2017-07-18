package com.yong.jpa.category;

import com.yong.jpa.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 19..
 */
@Data
@Entity
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;
}
