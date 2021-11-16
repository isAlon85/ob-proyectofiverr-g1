package com.g1fiverr.obproyectofiverrg1.repositories;

import com.g1fiverr.obproyectofiverrg1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}