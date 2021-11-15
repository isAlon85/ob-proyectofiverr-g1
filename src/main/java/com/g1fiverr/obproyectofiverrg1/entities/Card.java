package com.g1fiverr.obproyectofiverrg1.entities;

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
    private Integer category;
    @Column
    private Integer rating;
    @Column
    private Double price;

    public Card() {
    }

    public Card(Long id, String title, String description, String username, Integer category, Integer rating, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.username = username;
        this.category = category;
        this.rating = rating;
        this.price = price;
    }

//    public Card(Long id, String title, String description, String username, Integer category, Integer rating, Double price,
//                Set<Picture> pictures) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.username = username;
//        this.category = category;
//        this.rating = rating;
//        this.price = price;
//        this.pictures = pictures;
//    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CARD_PICTURES",
            joinColumns = {
                    @JoinColumn(name = "CARD_ID", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PICTURE_ID", referencedColumnName = "id") })

    private Set<Picture> pictures = new HashSet<>();

    public void addPicture(Picture picture){
        pictures.add(picture);
        picture.setCard(this);
    }

//    public void removePicture(Picture picture, boolean pictureExists){
//        pictures.remove(picture);
//        if (pictureExists) {
//            picture.getCard().remove(this);
//        }
//    }

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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
                ", pictures=" + pictures +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        return id != null && id.equals(((Card) obj).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
