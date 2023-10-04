package br.com.ricardo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardo.data.dto.v1.PersonDto;
import br.com.ricardo.exception.ResourceNotFoundException;
import br.com.ricardo.mapper.DozerMapper;
import br.com.ricardo.model.Person;
import br.com.ricardo.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public PersonDto findById(Long id) {
		logger.info("Finding a person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		return DozerMapper.parseObject(entity, PersonDto.class) ;
	}
	
	public List<PersonDto> findAll(){
		logger.info("Finding all person");
		return DozerMapper.parseListObjects(repository.findAll(), PersonDto.class) ;
	}
	
	public PersonDto createPerson(PersonDto person) {
		logger.info("Creating a person");
		var entity = DozerMapper.parseObject(person, Person.class);
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDto.class);
		return dto ;
	}

	public PersonDto updatePerson(PersonDto person) {
		logger.info("Updating a person");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException());
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDto.class);
		return dto;
	}
	
	public void deletePerson(Long id) {
		logger.info("Deleting a person");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		repository.delete(entity);
	}
}
