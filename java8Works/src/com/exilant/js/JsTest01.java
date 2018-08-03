package com.exilant.js;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsTest01 {

	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
//		String name = "Teja";
//		Integer result = null;
//		nashorn.eval("print('"+name+"')");
//	    result = (Integer)nashorn.eval("10+20");
//	    System.out.println("Result is: "+result);
		
		nashorn.eval(new FileReader("/Users/tejaswini.m/eclipse-workspace/java8Works/Resources/com/js/external.js"));
		
		System.out.println(nashorn.eval("fnTest()"));
		System.out.println(nashorn.eval("sayHello('harry')"));
		
	}

}
