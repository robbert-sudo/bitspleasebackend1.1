package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private long user_id;

    @Id
    @Column(nullable = false)
    private String authority;



    public Authority() {}
    public Authority(long user_id, String authority) {
        this.user_id = user_id;
        this.authority = authority;
    }

    public String getAuthority() {return authority;}
    public void setAuthority(String authority) {this.authority = authority;}
    public long getUserId() {return user_id;}
    public void setUserId(long user_id) {this.user_id = user_id;}
}
