package com.g1fiverr.obproyectofiverrg1.entities;

import javax.persistence.*;
import java.net.URI;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private URI uri;

    public Picture() {
    }

    public Picture(Long id, URI uri) {
        this.id = id;
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
