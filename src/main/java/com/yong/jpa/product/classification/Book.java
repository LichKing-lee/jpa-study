package com.yong.jpa.product.classification;

import com.yong.jpa.product.Product;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lichking on 2017. 7. 20..
 */
@Entity
@DiscriminatorValue("BOOK")
public class Book extends Product {
    @Column
    private String author;

    @Column
    private String isbn;
}
