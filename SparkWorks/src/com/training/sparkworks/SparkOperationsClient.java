package com.training.sparkworks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.apache.avro.file.SyncableFileOutputStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import com.training.commons.DataSource;
import com.training.commons.SparkConnection;
import com.training.commons.Utilities;

public class SparkOperationsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("org").setLevel(Level.ERROR);
		//optional
		Logger.getLogger("akka").setLevel(Level.ERROR);
		
		JavaSparkContext sparkContext = SparkConnection.getContext();
		//start loading the data
		//1)load the collection and cache it
		JavaRDD<Integer> collData = DataSource.getCollData();
		//System.out.println("Total number of records: "+collData.count());
		
		//2)Load the file and cache it
		JavaRDD<String> autoDataContent = sparkContext.textFile("./data/auto-data.csv");
		
		//to know number of records
		System.out.println("number of records: "+autoDataContent.count());
		//autoDataContent.take(5).forEach(System.out::println);
		
		//printing 5 lines of data
		System.out.println("loading data from file");
		//Utilities.printStringRDD(autoDataContent, 10);
		
		//storing RDD's
		//autoDataContent.saveAsTextFile("./data/auto-data-modified.csv");
		
		//spark transformation convertion from csv(comma seperated) to tsv(tab seperated)
		JavaRDD<String> tsvData = autoDataContent.map(str -> str.replace(',', '\t'));
		//Utilities.printStringRDD(tsvData, 10);
		
		///////////////////filter example///////////////////
		//to remove header
		
		String header = autoDataContent.first();
		JavaRDD<String> autoDataWithoutHeader = autoDataContent.filter(s -> !s.equals(header));
		//Utilities.printStringRDD(autoDataWithoutHeader, 5);
		
		JavaRDD<String> toyotaData = autoDataContent.filter(s -> s.contains("toyota"));
		//Utilities.printStringRDD(toyotaData, 10);
		
		//JavaRDD<String> uniqueData = autoDataContent.zipWithUniqueId().keys();
		JavaRDD<String> uniqueData = autoDataContent.distinct();
		//Utilities.printStringRDD(uniqueData, (int)uniqueData.count());
		//System.out.println(uniqueData.count());
		
		//to count number of words in the given RDD
		System.out.println("Using flat map: ");
		JavaRDD<String> words = toyotaData.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String t) throws Exception {
				// TODO Auto-generated method stub
				return Arrays.asList(t.split(",")).iterator();
			}
			
		});
		//System.out.println("ToyotoRDD Word Count: "+words.count());
		
		//after clensing data
		System.out.println("*********after clensing data**********");
		JavaRDD<String> clenseRDD = autoDataContent.map(new ClenseRDDCars());
		//Utilities.printStringRDD(clenseRDD, 5);
		
		//set Operations
		JavaRDD<String> words1 = sparkContext.parallelize(Arrays.asList("hello","how","are","you","today"));
		JavaRDD<String> words2 = sparkContext.parallelize(Arrays.asList("hello","how","were","you","yesterday"));
		System.out.println("Union operations - set");
		//Utilities.printStringRDD(words1.union(words2), 10);
		
		
		System.out.println("Intersection Operations Set");
		//Utilities.printStringRDD(words1.intersection(words2),9);
		
		//find sum of number in the given RDD
		
		Integer collDataCount = collData.reduce((x,y)->x+y);
		//System.out.println("Sum of given Integers: "+collDataCount);
		
		//first way
		Double avg_city_mileage = autoDataWithoutHeader.map(new getCityMileage()).collect().stream().mapToInt(x -> x).average().getAsDouble();
		System.out.println(avg_city_mileage);
		
		Double avg_highway_mileage = autoDataWithoutHeader.map(new getAvgHighway()).collect().stream().mapToInt(x -> x).average().getAsDouble();
		System.out.println(avg_highway_mileage);
		//second way		
		System.out.println(autoDataWithoutHeader.mapToDouble(a -> Double.valueOf(a.split(",")[9])).stats().mean());

		System.out.println(autoDataWithoutHeader.mapToDouble(a -> Double.valueOf(a.split(",")[8])).stats().mean());

		
		
		
		
		
		
		
		
		
	}

}
