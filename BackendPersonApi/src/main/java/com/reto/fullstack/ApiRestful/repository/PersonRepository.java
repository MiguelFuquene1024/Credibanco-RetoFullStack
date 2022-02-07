package com.reto.fullstack.ApiRestful.repository;

import com.reto.fullstack.ApiRestful.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,String> {
    Optional<Person> findById(Long id);
}
