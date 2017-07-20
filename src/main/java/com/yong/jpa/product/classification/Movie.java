package com.yong.jpa.product.classification;

import com.yong.jpa.product.Product;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lichking on 2017. 7. 20..
 */
@Entity
@DiscriminatorValue("MOVIE")
@Data
public class Movie extends Product {
    @Column
    private String director;

    @Column
    private String actor;
}
