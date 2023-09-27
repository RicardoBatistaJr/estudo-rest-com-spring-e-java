package br.com.ricardo.service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.ricardo.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		long idTest = counter.incrementAndGet();
		
		logger.info("Finding a person");
		Person mockPerson = new Person(idTest, "Ricardo","Junior","Recife - Pernambuco - Brasil", "Male");
		return mockPerson;
	}

	public Person newPerson(int i) {
		Person mockPerson = new Person(Long.valueOf(i), "Person n" + i ,"LastName" + i,"City n"+i, "Male");
		return mockPerson;
	}

}
