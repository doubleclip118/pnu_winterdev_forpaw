package com.hong.ForPaw.repository;

import com.hong.ForPaw.domain.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}