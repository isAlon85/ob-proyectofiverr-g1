package com.g1fiverr.obproyectofiverrg1.services;

import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PictureService {

    ResponseEntity<List<Picture>> findAll();

    ResponseEntity<Picture> findOneById(Long id);

    ResponseEntity<Picture> create(Picture Picture);

    ResponseEntity<Picture> update(Picture Picture);

    ResponseEntity delete(Long id);

    ResponseEntity deleteAll();

}
