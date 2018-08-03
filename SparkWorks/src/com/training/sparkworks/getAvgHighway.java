package com.training.sparkworks;

import org.apache.spark.api.java.function.Function;

public class getAvgHighway implements Function<String,Integer>{

	@Override
	public Integer call(String t) throws Exception {
		String[] attributeList = t.split(",");
		return Integer.parseInt(attributeList[9]);
	

		}

}
