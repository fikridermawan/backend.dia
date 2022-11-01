package com.task.backend.repository;

import com.task.backend.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonModel, Integer> {

    Optional<PersonModel> findByPersonEmail(String personEmail);
    Optional<PersonModel> findByPersonPassword(String personPassword);

}
