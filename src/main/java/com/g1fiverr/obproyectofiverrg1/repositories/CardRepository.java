package com.g1fiverr.obproyectofiverrg1.repositories;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long>{

    List<Card> findByCategory(Integer category);

    List<Card> findByUsername(String username);

}
