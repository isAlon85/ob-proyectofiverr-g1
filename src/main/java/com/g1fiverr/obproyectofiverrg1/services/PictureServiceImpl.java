package com.g1fiverr.obproyectofiverrg1.services;

import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import com.g1fiverr.obproyectofiverrg1.repositories.PictureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService{

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public ResponseEntity<List<Picture>> findAll(){
        if (pictureRepository.count() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pictureRepository.findAll());
    }

    @Override
    public ResponseEntity<Picture> findOneById(Long id){
        Optional<Picture> pictureOpt = pictureRepository.findById(id);

        if (pictureOpt.isPresent())
            return ResponseEntity.ok(pictureOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Picture> create(Picture picture){

        if (picture.getId() != null)
            return ResponseEntity.badRequest().build();


        Picture result = pictureRepository.save(picture);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Picture> update(Picture picture){

        if (picture.getId() == null)
            return ResponseEntity.badRequest().build();

        if (!pictureRepository.existsById(picture.getId()))
            return ResponseEntity.notFound().build();


        Picture result = pictureRepository.save(picture);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity delete(Long id){

        if (!pictureRepository.existsById(id))
            return ResponseEntity.notFound().build();

        pictureRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity deleteAll(){

        if (pictureRepository.count() == 0)
            return ResponseEntity.notFound().build();

        pictureRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}