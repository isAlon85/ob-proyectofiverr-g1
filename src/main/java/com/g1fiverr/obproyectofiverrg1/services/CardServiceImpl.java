package com.g1fiverr.obproyectofiverrg1.services;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import com.g1fiverr.obproyectofiverrg1.repositories.CardRepository;
import com.g1fiverr.obproyectofiverrg1.repositories.PictureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final PictureRepository pictureRepository;

    public CardServiceImpl(CardRepository cardRepository, PictureRepository pictureRepository) {
        this.cardRepository = cardRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public ResponseEntity<List<Card>> findAll(){
        if (cardRepository.count() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cardRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Card>> findByCategory(Integer category){
        if (cardRepository.findByCategory(category).size() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cardRepository.findByCategory(category));
    }

    @Override
    public ResponseEntity<List<Card>> findByUsername(String username) {

        if (cardRepository.findByUsername(username).size() == 0)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cardRepository.findByUsername(username));

    }

    @Override
    public ResponseEntity<Card> findOneById(Long id){
        Optional<Card> cardOpt = cardRepository.findById(id);

        if (cardOpt.isPresent())
            return ResponseEntity.ok(cardOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Card> create(Card card){

        if (card.getId() != null)
            return ResponseEntity.badRequest().build();

        if (card.getUsername().length() > 16) {
            return ResponseEntity.badRequest().build();
        }

        if (card.getTitle().length() > 50) {
            return ResponseEntity.badRequest().build();
        }
        Card result = cardRepository.save(card);
        if (card.getPictures() != null) {
            Iterator<Picture> it = result.getPictures().iterator();
            while (it.hasNext()) {
                result.addPicture(it.next());
            }
            result = cardRepository.save(result);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Card> addPicture(Long card_id, Picture picture){
        Optional<Card> resultCard = cardRepository.findById(card_id);
        resultCard.get().addPicture(picture);

        cardRepository.save(resultCard.get());
        pictureRepository.save(picture);

        return ResponseEntity.ok(resultCard.get());
    }


    @Override
    public ResponseEntity<Card> update(Card card){

        if (card.getId() == null)
            return ResponseEntity.badRequest().build();

        if (!cardRepository.existsById(card.getId()))
            return ResponseEntity.notFound().build();

        if (card.getUsername().length() > 16) {
            return ResponseEntity.badRequest().build();
        }

        if (card.getTitle().length() > 50) {
            return ResponseEntity.badRequest().build();
        }
        while (cardRepository.findById(card.getId()).get().getPictures().stream().count() != 0) {
            cardRepository.findById(card.getId()).get().removePicture(cardRepository.findById(card.getId()).get().getPictures().iterator().next());
        }
        Card result = cardRepository.save(card);
        if (card.getPictures() != null) {
            Iterator<Picture> it = result.getPictures().iterator();
            while (it.hasNext()) {
                result.addPicture(it.next());
            }
            result = cardRepository.save(result);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity delete(Long id){

        if (!cardRepository.existsById(id))
            return ResponseEntity.notFound().build();

        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity deleteAll(){

        if (cardRepository.count() == 0)
            return ResponseEntity.notFound().build();

        cardRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
