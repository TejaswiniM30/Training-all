package com.exilant.day2;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DragonsClient {

	public static void main(String[] args) {
		List<Dragons> dragonList = Stream.of(
					new Dragons("Errol", "USA", 15),
					new Dragons("Errol", "Paris", 33),
					new Dragons("Firnan", "USA", 5),
					new Dragons("Hasai", "France", 20),
					new Dragons("Harry", "Norway", 34),
					new Dragons("Harry", "Bermuda", 20),
					new Dragons("Bonfire", "Iceland", 23),
					new Dragons("Atlanta", "Iceland", 24),
					new Dragons("Georgia", "Norway", 24)
					).collect(Collectors.toList());
		
		//to find number of dragons
		Map<String, Long> mapDragonCount = dragonList.stream()
				.collect(Collectors.groupingBy(Dragons ::getName, Collectors.counting()));
		System.out.println(mapDragonCount);
		
		Map<String, Integer>  sumOfDragons = dragonList.stream().collect(Collectors.groupingBy(Dragons :: getName, Collectors.summingInt(Dragons ::getCount)));
		sumOfDragons.forEach(
				(k,v) -> {
					System.out.println("Dragon Name "+k+", Number of Dragons "+v);
				}
				);	
		//write a java 8 snippet to find the stats of the dragonList
		//should display sum/average/min/max/avg of dragons
		
		//find dragon by country and keep the names of dragons
		//of different countries in the list/set
		
		System.out.println("--------------");
		Map<String, Double>  avgOfDragons = dragonList.stream().collect(Collectors.groupingBy(Dragons :: getName, Collectors.averagingInt(Dragons ::getCount)));
		avgOfDragons.forEach(
				(k,v) -> {
					System.out.println("Dragon Name "+k+", Average dragons "+v);
				}
				);	
//		int  minOfDragons = dragonList.stream().mapToInt(x -> (int)x.getCount()).min().getAsInt();
//		System.out.println(minOfDragons);
//		int  maxOfDragons = dragonList.stream().mapToInt(x -> (int)x.getCount()).max().getAsInt();
//		System.out.println(maxOfDragons);
		
		IntSummaryStatistics stats = dragonList.stream().mapToInt(x -> x.getCount()).summaryStatistics();
		System.out.println("Sum is: "+stats.getSum());
		System.out.println("Avg is: "+stats.getAverage());
		System.out.println("Min is: "+stats.getMin());
		System.out.println("Max is: "+stats.getMax());
		System.out.println("count is: "+stats.getCount());
		 
		System.out.println("----------by country--------------");
		
		 Map<String, Set<String>> byCountry=dragonList.stream().collect(Collectors.groupingBy(Dragons ::getCountry, Collectors.mapping(Dragons :: getName, Collectors.toSet())));
		 byCountry.forEach(
					(k,v) -> {
						System.out.println("Dragon Name "+k+", dragons names "+v);
					}
					);
		
		
	}

}
