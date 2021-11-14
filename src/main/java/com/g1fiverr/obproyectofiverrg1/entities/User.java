package com.g1fiverr.obproyectofiverrg1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(mappedBy="idCard")
    private Long id;
    private String username;
    private String password;
    private String email;
    @OneToOne(mappedBy="id")
    private Card card;

    public User() {
    }

    public User(Long id, String username, String password, String email, Card card) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Card getListCards() {
        return card;
    }

    public void setListCards(Card card) {
        this.card = card;
    }
}
