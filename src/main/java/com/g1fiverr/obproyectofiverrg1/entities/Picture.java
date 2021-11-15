package com.g1fiverr.obproyectofiverrg1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.net.URI;
import java.util.Objects;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
//    @JsonBackReference
    private Card card;

    @Column
    private String url;

    public Picture() {
    }

    public Picture(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
