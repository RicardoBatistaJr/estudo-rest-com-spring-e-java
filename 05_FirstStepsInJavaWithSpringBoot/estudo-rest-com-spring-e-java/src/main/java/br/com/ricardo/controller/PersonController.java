package br.com.ricardo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.model.Person;
import br.com.ricardo.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping()
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@GetMapping(value = "{id}")
	public Person findById(
			@PathVariable(value = "id") Long id) {
		return personService.findById(id);
	}
	
	@GetMapping()
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@PutMapping()
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> deletePerson(
			@PathVariable(value = "id") Long id) {
		personService.deletePerson(id);
		return ResponseEntity.noContent().build();
	}
}
