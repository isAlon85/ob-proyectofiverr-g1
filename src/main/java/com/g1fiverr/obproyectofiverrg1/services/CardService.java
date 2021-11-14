package com.g1fiverr.obproyectofiverrg1.services;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.repositories.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public ResponseEntity<List<Card>> findAll(){
        if (cardRepository.count() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cardRepository.findAll());
    }

    public ResponseEntity<Card> findOneById(Long id){
        Optional<Card> cardOpt = cardRepository.findById(id);

        if (cardOpt.isPresent())
            return ResponseEntity.ok(cardOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

//    //En desarrollo por Daniel
//    public ResponseEntity<List<Card>> findByCategory(String category){
//        Optional<List<Card>> listCardOpt = cardRepository.fi
//    }

    public ResponseEntity<Card> create(Card card){

        if (card.getId() != null)
            return ResponseEntity.badRequest().build();

        if (card.getUsername().length() > 16) {
            return ResponseEntity.badRequest().build();
        }

        if (card.getDescription().length() > 50) {
            return ResponseEntity.badRequest().build();
        }

        Card result = cardRepository.save(card);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Card> update(Card card){

        if (card.getId() == null)
            return ResponseEntity.badRequest().build();

        if (!cardRepository.existsById(card.getId()))
            return ResponseEntity.notFound().build();

        if (card.getUsername().length() > 16) {
            return ResponseEntity.badRequest().build();
        }

        if (card.getDescription().length() > 50) {
            return ResponseEntity.badRequest().build();
        }

        Card result = cardRepository.save(card);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity delete(Long id){

        if (!cardRepository.existsById(id))
            return ResponseEntity.notFound().build();

        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity deleteAll(){

        if (cardRepository.count() == 0)
            return ResponseEntity.notFound().build();

        cardRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
