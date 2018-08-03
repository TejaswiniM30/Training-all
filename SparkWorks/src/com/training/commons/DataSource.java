package com.training.commons;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class DataSource {
	//simulating the data is pulled from some resources
	public static JavaRDD<Integer> getCollData(){
		JavaSparkContext spContext = SparkConnection.getContext();
		List<Integer> data = Arrays.asList(3,4,56,78,45,34,89,44,22);
		
		JavaRDD<Integer> collData = spContext.parallelize(data);
		collData.cache();
		return collData;
		
	}
}
