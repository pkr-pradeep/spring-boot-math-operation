package com.pkr.learning.springboot.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pkr.learning.springboot.exception.ItemNotFoundException;

@Service
public class Calculator {
	public String add(int a, int b) {
		System.out.println("Hello World");
		System.out.println("summation:"+(a+b));
		return "Summation of two given numbers "+a+" & "+b+" is:"+Integer.toString(a+b);
	}
	
	public List<Integer> createMultiplicationTable(int number) {
		List<Integer> mtValue = new ArrayList<>();
		for(int i = 1; i<= 10; i++) {
			mtValue.add(i*number);
		}
		return mtValue;
	}
	
	public void addIntoOddNumberList(int number, List<Integer> primenumbers) {
		if(number % 2 != 0) {
			primenumbers.add(number);
		}
	}
	
	public void removeOddNumberFromList(int number, List<Integer> primenumbers) {
		if(null == primenumbers || primenumbers.size() == 0) {
			return;
		}
		if(!primenumbers.contains(number)) {
			throw new ItemNotFoundException();
		}
		if(primenumbers.contains(number)) {
			primenumbers.remove(primenumbers.indexOf(number));
		}
	}
	
	public void updateTheOddNumberIntoTheList(int number, int uNnumber, List<Integer> primenumbers) {
		Collections.sort(primenumbers);
		if(null == primenumbers || primenumbers.size() == 0 || number % 2 == 0) {
			return;
		} 
		if(!primenumbers.contains(number)) {
			throw new ItemNotFoundException();
		}
		for(Integer intr : primenumbers) {
			if(number == intr) {
				int index = primenumbers.indexOf(intr);
				primenumbers.remove(primenumbers.indexOf(intr));
				primenumbers.add(index, uNnumber);
				break;
			}
		}
	}
}
