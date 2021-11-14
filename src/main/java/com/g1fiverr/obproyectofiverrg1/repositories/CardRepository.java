package com.g1fiverr.obproyectofiverrg1.repositories;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
}
