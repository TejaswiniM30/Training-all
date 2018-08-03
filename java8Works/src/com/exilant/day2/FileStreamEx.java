package com.exilant.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class FileStreamEx {

	public static void main(String[] args) throws IOException {
//		Files.list(Paths.get("./Files1")).
//		map(Path :: getFileName).
//		map(Path :: toString).
//		map(String :: toUpperCase).
//		filter(name -> name.endsWith("TXT")).
//		sorted().
//		skip(2).
//		limit(2).
//		forEach(name -> doSomeAction(name) );
		
		Files.list(Paths.get("./Files1")).filter(t -> {
			try {
				return doSomeAction(t);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).map(Path :: getFileName).forEach(System.out :: println);
	}




public static boolean doSomeAction(Path filePath) throws FileNotFoundException {
	BufferedReader br = new BufferedReader(new FileReader(filePath.toString()));
	long l = br.lines().filter(s -> s.contains("Exilant")).count();
	return (l>0)?true:false;
}
}
