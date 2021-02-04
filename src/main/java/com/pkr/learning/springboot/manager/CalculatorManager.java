package com.pkr.learning.springboot.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.learning.springboot.Services.Calculator;

@RestController
public class CalculatorManager {
	
	private static List<Integer> primenumbers = new ArrayList<>(); 
	
	@Autowired
	Calculator calculator;
	
	@RequestMapping("/calc/sum")
	//http://localhost:9191/calc/sum?num1=8&num2=9
	//URL for multiple parameters
	public String init(@RequestParam(name = "num1", defaultValue = "5") String number,
			@RequestParam(name = "num2", defaultValue = "6") String number2) {
		return calculator.add(Integer.parseInt(number), Integer.parseInt(number2));
	}
	
	@RequestMapping("mt/{num1}")
	//http://localhost:9191/mt/7
	public List<Integer> multiplicatioTableForAnyNumber(@PathVariable("num1") int number){
		return calculator.createMultiplicationTable(number);
	}
	
	@RequestMapping(value="odd/get", method=RequestMethod.GET)
	//http://localhost:9191/odd/get
	public List<Integer> createOddNumberList(){
		 return primenumbers;
	}
	
	@RequestMapping(value="odd/add/{num1}", method=RequestMethod.POST)
	//http://localhost:9191/odd/add/23
	public List<Integer> createOddNumberList(@PathVariable("num1") int number){
		 calculator.addIntoOddNumberList(number, primenumbers);
		 return primenumbers;
	}
	
	@RequestMapping(value="odd/update/{num1}/{num2}", method=RequestMethod.PUT)
	//http://localhost:9191/odd/update/23/25
	public List<Integer> updateOddNumberList(@PathVariable("num1") int number, @PathVariable("num2") int uNumber){
		 calculator.updateTheOddNumberIntoTheList(number,uNumber, primenumbers);
		 return primenumbers;
	}
	
	@RequestMapping(value="odd/delete/{num1}", method=RequestMethod.DELETE)
	//http://localhost:9191/odd/delete/23
	public List<Integer> deleteOddNumberFromTheList(@PathVariable("num1") int number){
		 calculator.removeOddNumberFromList(number, primenumbers);
		 return primenumbers;
	}
}
