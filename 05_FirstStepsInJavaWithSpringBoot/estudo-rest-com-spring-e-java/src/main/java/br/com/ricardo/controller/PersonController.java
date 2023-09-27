package br.com.ricardo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.model.Person;
import br.com.ricardo.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/findById/{id}")
	public Person findById(
			@PathVariable(value = "id") String id) {
		Person p = personService.findById(id);
		return p;
	}

	
	@GetMapping(value = "/findAll")
	public List<Person> findAll(){
		List<Person> People = new ArrayList<>();
		for(int i=0; i<=8; i++) {
			Person mockPerson = personService.newPerson(i);
			People.add(mockPerson);
		}
		return People;
	}
}
