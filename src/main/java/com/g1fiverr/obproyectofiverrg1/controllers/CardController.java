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

/**
 * Configuración del Controlador Rest de Cards (clase responsable por "escuchar" las requisiciones HTTP)
 * Ver url:port/swagger-ui/ para consultar la documentación
 */
@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CardController {

    private final String ROOT = "/api/cards";
    private final Logger log = LoggerFactory.getLogger(CardController.class);
    private final CardServiceImpl cardService;

    public CardController(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    @GetMapping(ROOT)
    @ApiOperation("Find all cards in DB")
    public ResponseEntity<List<Card>> findAll() {
        return cardService.findAll();
    }

    @GetMapping(ROOT + "/category/" + "{category}")
    @ApiOperation("Find cards in DB by category")
    public ResponseEntity<List<Card>> findByCategory(@PathVariable String category) {
        return cardService.findByCategory(category);
    }

    @GetMapping(ROOT + "/username/" + "{username}")
    @ApiOperation("Find cards in DB by username")
    public ResponseEntity<List<Card>> findByUsername(@PathVariable String username){
        return cardService.findByUsername(username);
    }

    @GetMapping(ROOT + "/rating/" + "{rating}")
    @ApiOperation("Find cards in DB by rating")
    public ResponseEntity<List<Card>> findByUsername(@PathVariable Integer rating){
        return cardService.findByRating(rating);
    }

    @GetMapping(ROOT + "/max-price/" + "{price}")
    @ApiOperation("Find cards in DB by maximal price")
    public ResponseEntity<List<Card>> findByMaximalPrice(@PathVariable Double price){
        return cardService.findByMaximalPrice(price);
    }

    @GetMapping(ROOT + "/min-price/" + "{price}")
    @ApiOperation("Find cards in DB by minimal price")
    public ResponseEntity<List<Card>> findByMinimalPrice(@PathVariable Double price){
        return cardService.findByMinimalPrice(price);
    }

    @GetMapping(ROOT + "/rangeofprices/" + "{minPrice}/" + "{maxPrice}")
    @ApiOperation("Find cards in DB by a range of prices")
    public ResponseEntity<List<Card>> findByRangeOfPrices(@PathVariable Double minPrice, @PathVariable Double maxPrice){
        return cardService.findByRangeOfPrices(minPrice, maxPrice);
    }

    @GetMapping(ROOT + "/" + "{id}")
    @ApiOperation("Find a card in DB by ID")
    public ResponseEntity<Card> findOneById(@PathVariable Long id) {
        return cardService.findOneById(id);
    }

    @PostMapping(ROOT)
    @ApiOperation("Create a card in DB with a JSON")
    public ResponseEntity<Card> create(@RequestBody Card card) {
        ResponseEntity<Card> result = cardService.create(card);

        if (result.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            log.warn("Trying to create a Card with ID");

        return result;
    }

    @PutMapping(ROOT)
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
    @ApiOperation("Delete a card in DB by ID")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity result = cardService.delete(id);

        if (result.getStatusCode().equals(HttpStatus.NOT_FOUND))
            log.warn("Trying to delete a Card with a non existing ID");

        return result;
    }

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
