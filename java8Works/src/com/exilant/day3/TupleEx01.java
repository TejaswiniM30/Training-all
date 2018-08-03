package com.exilant.day3;

import java.util.ArrayList;
import java.util.List;

class MyTuple<A, B, C>{
	private A _aa;
	private B _bb;
	private C _cc;
	public A get_aa() {
		return _aa;
	}
	public void set_aa(A _aa) {
		this._aa = _aa;
	}
	public B get_bb() {
		return _bb;
	}
	public void set_bb(B _bb) {
		this._bb = _bb;
	}
	public C get_cc() {
		return _cc;
	}
	public void set_cc(C _cc) {
		this._cc = _cc;
	}
	public MyTuple(A _aa, B _bb, C _cc) {
		super();
		this._aa = _aa;
		this._bb = _bb;
		this._cc = _cc;
	}
	public MyTuple() {
		super();
	}
	
}

class Emp{}
class Dept{}
class SomeThing{}


public class TupleEx01 {
	public static MyTuple<Integer, String, Boolean> newtuple(){
		return new MyTuple<Integer, String, Boolean>(100, "Hello", true);
	}
	
	public static MyTuple<Emp, Dept, SomeThing> newCustomTuple(){
		return new MyTuple<Emp, Dept, SomeThing>(new Emp(), new Dept(), new SomeThing());
	}
	public static void main(String[] args) {
		MyTuple<Integer, String, Boolean> tuple1 = newtuple();
		System.out.println("Integer value: "+tuple1.get_aa());
		System.out.println("String value: "+tuple1.get_bb());
		System.out.println("Boolean value: "+tuple1.get_cc());
		
		List<MyTuple<Integer, String, Boolean>> myList = 
				new ArrayList<MyTuple<Integer, String, Boolean>>();
		myList.add(new MyTuple<Integer, String, Boolean>(200, "Teja", true));
		myList.add(new MyTuple<Integer, String, Boolean>(300, "Rama", true));
		myList.add(new MyTuple<Integer, String, Boolean>(400, "ABC", false));
		myList.add(new MyTuple<Integer, String, Boolean>(500, "XYZ", false));
		myList.forEach(x -> System.out.println(x.get_aa()+" "+x.get_bb()+" "+x.get_cc()));


	}
}
