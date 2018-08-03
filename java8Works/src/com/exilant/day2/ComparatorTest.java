package com.exilant.day2;

public class ComparatorTest {

	public static void main(String[] args) {
		ComparatorInterface c1 = (a,b)->{
			if(a.length()>b.length())
				return a;
			else 
				return b;
		};
		
		ComparatorInterface c2 = (a,b)->{
			return ((a.length()<b.length())?a:b);
			
		};
		
		ComparatorRunner.execute(c1,"Teja","Exilant");
		ComparatorRunner.execute(c2,"Teja","Exilant");
		}

}
