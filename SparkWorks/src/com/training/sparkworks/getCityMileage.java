package com.training.sparkworks;

import org.apache.spark.api.java.function.Function;

public class getCityMileage implements Function<String,Integer>{

	@Override
	public Integer call(String t) throws Exception {
		String[] attributeList = t.split(",");
		return Integer.parseInt(attributeList[8]);
	

	}

	

}
