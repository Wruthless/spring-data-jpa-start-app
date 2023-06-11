package com.wruthless.persistentcollections.model;

import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;


    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Users getUser() {
        return user;
    }
}
