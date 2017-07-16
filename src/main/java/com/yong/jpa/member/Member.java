package com.yong.jpa.member;

import com.yong.jpa.common.Register;
import com.yong.jpa.purchase.Purchase;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 11..
 */
@Entity
@Data
public class Member extends Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

    @Column
    private int age;

    @OneToMany
    private List<Purchase> purchases;

    @Override
    public String toString(){
        return "id :: " + this.id + " username :: " + this.username + " age :: " + this.age;
    }
}
