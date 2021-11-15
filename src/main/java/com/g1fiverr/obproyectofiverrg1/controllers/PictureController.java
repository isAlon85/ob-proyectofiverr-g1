package com.g1fiverr.obproyectofiverrg1.controllers;

import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import com.g1fiverr.obproyectofiverrg1.services.PictureServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PictureController/*<CarService>*/ {

    private final String ROOT = "/api/pictures";
    private final Logger log = LoggerFactory.getLogger(PictureController.class);
    private PictureServiceImpl pictureService;

    public PictureController(PictureServiceImpl pictureService) {
        this.pictureService = (PictureServiceImpl) pictureService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT)
    @ApiOperation("Find all pictures in DB")
    public ResponseEntity<List<Picture>> findAll() {
        ResponseEntity result = pictureService.findAll();
        return result;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT + "/" + "{id}")
    @ApiOperation("Find a picture in DB by ID")
    public ResponseEntity<Picture> findOneById(@PathVariable Long id) {
        return pictureService.findOneById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(ROOT)
    @ApiOperation("Create a picture in DB with a JSON")
    public ResponseEntity<Picture> create(@RequestBody Picture picture) {
        ResponseEntity<Picture> result = pictureService.create(picture);

        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            log.warn("Trying to create a Picture with ID");

        return result;
    }

    @PutMapping(ROOT)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Update a picture in DB with a JSON")
    public ResponseEntity<Picture> updateBook(@RequestBody Picture picture) {
        ResponseEntity<Picture> result = pictureService.update(picture);

        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            log.warn("Trying to update a Picture without ID");

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("Trying to update a Picture with a non existing ID");

        return result;
    }

    @DeleteMapping(ROOT + "/" + "{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Delete a picture in DB by ID")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity result = pictureService.delete(id);

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("Trying to delete a laptop with a non existing ID");

        return result;
    }

    //    @ApiIgnore
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(ROOT + "/" + "restartDB")
    public ResponseEntity deleteAll(@RequestHeader HttpHeaders headers) {
        ResponseEntity result = pictureService.deleteAll();

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("The DB is already empty");
        else
            log.warn("Deleting all by request of " + headers.get("User-Agent"));

        return result;
    }
}
