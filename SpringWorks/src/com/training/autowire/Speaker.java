package com.training.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Speaker {
	
	private String type;
	
	private int volLevels;
	public String getType() {
		return type;
	}
	
	@Value("${speaker.type}")
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getVolLevels() {
		return volLevels;
	}
	
	
	@Value("${speaker.volLevels}")
	public void setVolLevels(int volLevels) {
		this.volLevels = volLevels;
	}
	public Speaker(String type, int volLevels) {
		super();
		this.type = type;
		this.volLevels = volLevels;
	}
	public Speaker() {
		super();
		System.out.println("Creating speaker.."+this);
	}
	@Override
	public String toString() {
		return "Speaker [type=" + type + ", volLevels=" + volLevels + "]";
	}
	
	
}
