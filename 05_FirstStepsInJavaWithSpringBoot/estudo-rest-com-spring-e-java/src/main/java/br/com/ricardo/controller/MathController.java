package br.com.ricardo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.exception.UnsupportedMathOperationException;
import br.com.ricardo.service.MathService;

@RestController
public class MathController {
	
	@Autowired
	private MathService mathService;
	
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException();
		} return mathService.sum(numberOne, numberTwo);
	} 
	
	@GetMapping(value = "/subtract/{numberOne}/{numberTwo}")
	public Double subtract(
			@PathVariable(value = "numberOne")String numberOne,
			@ PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException();
		} return mathService.subtract(numberOne, numberTwo);
	} 
	
	@GetMapping(value = "/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException();
		} return mathService.multiply(numberOne, numberTwo);
	} 
	
	@GetMapping(value = "/divide/{numberOne}/{numberTwo}")
	public Double divide(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException();
		} return mathService.divide(numberOne, numberTwo);
	} 
	
	@GetMapping(value = "/average/{numbers}")
	public Double average(
			@PathVariable(value = "numbers") List<String> numbers) throws Exception{
		for(int i = 0; i<numbers.size(); i++) {
			String value = numbers.get(i);
		if(!mathService.isNumeric(value)) {
			throw new UnsupportedMathOperationException();
			}
		}
		return mathService.average(numbers);
	} 
	
	@GetMapping(value = "/squaredRoot/{numberOne}")
	public Double squaredRoot(
			@PathVariable(value = "numberOne")String numberOne) throws Exception{
		
		if(!mathService.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException();
		} return mathService.squaredRoot(numberOne);
	} 
}
 