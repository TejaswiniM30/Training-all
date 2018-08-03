package com.training.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Screen {
	
private String glassType;
private int len;
private int bre;
public String getGlassType() {
	return glassType;
}


@Value("${screen.glassType}")
public void setGlassType(String glassType) {
	this.glassType = glassType;
}
public int getLen() {
	return len;
}


@Value("${screen.len}")
public void setLen(int len) {
	this.len = len;
}
public int getBre() {
	return bre;
}


@Value("${screen.bre}")
public void setBre(int bre) {
	this.bre = bre;
}
public Screen(String glassType, int len, int bre) {
	super();
	this.glassType = glassType;
	this.len = len;
	this.bre = bre;
}
public Screen() {
	super();
	System.out.println("creating screen:  "+this);
}
@Override
public String toString() {
	return "Screen [glassType=" + glassType + ", len=" + len + ", bre=" + bre + "]";
}





}
