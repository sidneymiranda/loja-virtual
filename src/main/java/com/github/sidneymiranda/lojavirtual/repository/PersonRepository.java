package com.github.sidneymiranda.lojavirtual.repository;

import com.github.sidneymiranda.lojavirtual.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
