package com.g1fiverr.obproyectofiverrg1.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String username;
    @Column
    private String category;
    @Column
    private Double rating;
    @Column
    private Double price;

    public Card() {
    }

    public Card(Long id, String title, String description, String username, String category,Double rating, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.username = username;
        this.category = category;
        this.rating = rating;
        this.price = price;
    }

    public Card(Long id, String title, String description, String username, String category,Double rating, Double price,
                Set<Picture> pictures) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.username = username;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.pictures = pictures;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CARD_PICTURES",
            joinColumns = {
                    @JoinColumn(name = "CARD_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PICTURE_ID") })

    private Set<Picture> pictures;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
