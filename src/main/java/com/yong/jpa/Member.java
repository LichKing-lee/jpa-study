package com.yong.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lichking on 2017. 7. 11..
 */
@Getter
@Setter
@Entity
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;
    @Column(name = "name")
    private String username;
    private int age;

    @Override
    public String toString(){
        return "id :: " + this.id + " username :: " + this.username + " age :: " + this.age;
    }
}
