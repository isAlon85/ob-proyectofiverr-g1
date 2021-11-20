package com.g1fiverr.obproyectofiverrg1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
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
    private Integer rating;
    @Column
    private Double price;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Picture> pictures = new HashSet<>();


    public Card() {
    }

    public Card(Long id, String title, String description, String username, String category, Integer rating, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.username = username;
        this.rating = rating;
        this.category = category;
        this.price = price;
    }

    public void addPicture(Picture picture){
        pictures.add(picture);
        picture.setCard(this);
    }

    public void removePicture(Picture picture){
        pictures.remove(picture);
        picture.removeCard();
    }

    public Set<Picture> getPictures(){
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
