package br.com.ricardo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathService {
		
	public Double sum(String numberOne, String numberTwo) {
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	public Double subtract(String numberOne, String numberTwo) {
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	public Double divide(String numberOne, String numberTwo) {
		 return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	public Double multiply(String numberOne, String numberTwo) {
		 return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	public Double average(List<String> numberList) {
		Double sum = (double) 0;
		Double items = (double) 0;
		
		for(int i=0; i<numberList.size(); i++) {
			Double value = convertToDouble(numberList.get(i));
			sum = sum + value;
			items++;
		}
		return sum / items;
	}
	
	public Double squaredRoot(String numberOne) {
		return Math.sqrt(convertToDouble(numberOne));
	}
	
	public Double convertToDouble(String strNumber) {
		if(strNumber ==null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public boolean isNumeric(String strNumber) {
		if(strNumber ==null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}
