package com.g1fiverr.obproyectofiverrg1.controllers;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CardController<CardService> {

    private final String ROOT = "/api/v1/cards";
    //private final Logger log = LoggerFactory.getLogger(CardController.class);
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT)
    @ApiOperation("Busca todos los cards de la DB")
    public List<Card> findAll() {
        return cardService.findAll();
    }

    //    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT + "/" + "{id}")
    @ApiOperation("Busca una Card por clave primaria ID")
    public ResponseEntity<Card> findOneById(@PathVariable Long id) {
        return cardService.findOneById(id);
    }

    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(ROOT)
    @ApiOperation("Crea un objeto card a partir de un JSON")
    public ResponseEntity<Card> create(@RequestBody Card card) {
        ResponseEntity<Card> result = cardService.create(card);

//        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
//            log.warn("Trying to create a card with ID");

        return result;
    }

    @PutMapping(ROOT)
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Actualiza un objeto card a partir de un JSON")
    public ResponseEntity<Card> updateBook(@RequestBody Card card) {
        ResponseEntity<Card> result = cardService.update(card);

//        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
//            log.warn("Trying to update a laptop without ID");
//
//        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
//            log.warn("Trying to update a laptop with a non existing ID");

        return result;
    }

    @DeleteMapping(ROOT + "/" + "{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Borra una card a partir del ID pasado como parametro en la URL")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity result = cardService.delete(id);

//        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
//            log.warn("Trying to delete a laptop with a non existing ID");

        return result;
    }

    //    @ApiIgnore
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(ROOT + "/" + "restartDB")
    public ResponseEntity deleteAll(@RequestHeader HttpHeaders headers) {
        ResponseEntity result = cardService.deleteAll();

//        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
//            log.warn("The DB is already empty");
//        else
//            log.warn("Deleting all by request of " + headers.get("User-Agent"));

        return result;
    }
}
