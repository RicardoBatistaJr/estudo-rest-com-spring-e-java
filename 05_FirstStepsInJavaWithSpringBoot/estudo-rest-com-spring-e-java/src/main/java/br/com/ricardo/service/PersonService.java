package br.com.ricardo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardo.exception.ResourceNotFoundException;
import br.com.ricardo.model.Person;
import br.com.ricardo.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public Person findById(Long id) {
		logger.info("Finding a person");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public List<Person> findAll(){
		logger.info("Finding all person");
		return repository.findAll();
	}
	
	public Person createPerson(Person person) {
		logger.info("Creating a person");
		return repository.save(person);
	}

	public Person updatePerson(Person person) {
		logger.info("Updating a person");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException());
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	public void deletePerson(Long id) {
		logger.info("Deleting a person");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		repository.delete(entity);
	}
}
