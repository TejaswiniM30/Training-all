package com.exilant.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	public static void main(String[] args) throws IOException {
	//	writeToFile01();
		readFromFile();
	}
	
//	public static void writeToFile() {
//		//earlier to 1.8
//		
//		BufferedWriter bw = null;
//		
//		try{
//			bw = new BufferedWriter(new FileWriter("Sample.txt"));
//			bw.write("Hello");
//			bw.newLine();
//			bw.write("How are you today");
//			bw.newLine();
//			bw.write("nice weather");
//			bw.newLine();
//			bw.write("Data saved successfully");
//			
//		}catch(IOException ieo) {
//			ieo.printStackTrace();
//		}finally {
//			try {
//			bw.close();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//			
//		
//	}
//	public static void writeToFile01() throws IOException{
//		try(BufferedWriter bw = new BufferedWriter(new FileWriter("NewSample.txt"))){
//			bw.write("Hello");
//			bw.newLine();
//			bw.write("How are you today");
//			bw.newLine();
//			bw.write("nice weather");
//			bw.newLine();
//			//bw.write("Data saved successfully");
//		}
//		System.out.println("Data saved successfully");
//	}
	
	public static void readFromFile() throws IOException{
		try(FileReader fr = new FileReader("NewSample.txt");
			BufferedReader br = new BufferedReader(fr);){
			br.lines().forEach(System.out::println);
//			String str ="";
//			while((str = bw.readLine())!=null) {
//				System.out.println(str);
//				System.out.println();
//			}
			//bw.write("Data saved successfully");
		}
		System.out.println("Data read successfully");
	}

}
