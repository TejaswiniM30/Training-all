package com.exilant.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

	public static void main(String[] args) {
		Predicate<Integer> greaterThan = i -> i>10;
		Predicate<Integer> lessThan = i -> i<10;
		List<Integer> integerList = Arrays.asList(12, 23, 34, 45, -33, -10,2, 77);
		Predicate<Integer> positiveNumbers = i -> i>0;
		Predicate<Integer> betweenRange = i -> 1>0 && i<100;
		Predicate<Integer> compound = positiveNumbers.and(betweenRange);
	//	List<Integer> greater10 = integerList.stream().filter(greaterThan).collect(Collectors.toList());
		
		List<Integer> fl = filteredList(integerList, compound);
		fl.forEach(System.out :: println);
	}
	
	public static List<Integer> filteredList(List<Integer> numbers, Predicate<Integer> p){
		List<Integer> filteredlist = new ArrayList<Integer>();
		for(Integer temp : numbers) {
			if(p.test(temp))
				filteredlist.add(temp);
		}
		return filteredlist;
		
	}

}
