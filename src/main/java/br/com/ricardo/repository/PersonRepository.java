package br.com.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
