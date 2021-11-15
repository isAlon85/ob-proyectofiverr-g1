package com.g1fiverr.obproyectofiverrg1.services;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {

    ResponseEntity<List<Card>> findAll();

    ResponseEntity<Card> findOneById(Long id);

    ResponseEntity<Card> create(Card card);

    ResponseEntity<Card> update(Card card);

    ResponseEntity delete(Long id);

    ResponseEntity deleteAll();

}
