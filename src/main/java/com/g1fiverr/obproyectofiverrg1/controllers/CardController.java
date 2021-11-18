package com.g1fiverr.obproyectofiverrg1.controllers;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.services.CardServiceImpl;
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
public class CardController {

    private final String ROOT = "/api/cards";
    private final Logger log = LoggerFactory.getLogger(CardController.class);
    private final CardServiceImpl cardService;

    public CardController(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

   //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT)
    @ApiOperation("Find all cards in DB")
    public ResponseEntity<List<Card>> findAll() {
        return cardService.findAll();
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT + "/category/" + "{category}")
    @ApiOperation("Find cards in DB by category")
    public ResponseEntity<List<Card>> findByCategory(@PathVariable Integer category) {
        return cardService.findByCategory(category);
    }

    @GetMapping(ROOT + "/username/" + "{username")
    @ApiOperation("Find cards in DB by username")
    public ResponseEntity<List<Card>> findByUsername(@PathVariable String username){
        return cardService.findByUsername(username);
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(ROOT + "/" + "{id}")
    @ApiOperation("Find a card in DB by ID")
    public ResponseEntity<Card> findOneById(@PathVariable Long id) {
        return cardService.findOneById(id);
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(ROOT)
    @ApiOperation("Create a card in DB with a JSON")
    public ResponseEntity<Card> create(@RequestBody Card card) {
        ResponseEntity<Card> result = cardService.create(card);

        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            log.warn("Trying to create a Card with ID");

        return result;
    }

    @PutMapping(ROOT)
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Update a card in DB with a JSON")
    public ResponseEntity<Card> updateBook(@RequestBody Card card) {
        ResponseEntity<Card> result = cardService.update(card);

        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            log.warn("Trying to update a Card without ID");

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("Trying to update a Card with a non existing ID");

        return result;
    }

    @DeleteMapping(ROOT + "/" + "{id}")
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Delete a card in DB by ID")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity result = cardService.delete(id);

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("Trying to delete a Card with a non existing ID");

        return result;
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(ROOT + "/" + "restartDB")
    public ResponseEntity deleteAll(@RequestHeader HttpHeaders headers) {
        ResponseEntity result = cardService.deleteAll();

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("The DB is already empty");
        else
            log.warn("Deleting all by request of " + headers.get("User-Agent"));

        return result;
    }
}
