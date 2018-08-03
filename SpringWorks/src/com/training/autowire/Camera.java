package com.training.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//all components are eligible to be autowired
@Component
public class Camera {
	
	private String type;

	public String getType() {
		return type;
	}
	
	@Value("${camera.type}")
	public void setType(String type) {
		this.type = type;
	}

	public Camera(String type) {
		super();
		this.type = type;
	}

	public Camera() {
		super();
		System.out.println("Creating camera.."+this);
	}

	@Override
	public String toString() {
		return "Camera [type=" + type + "]";
	}
	
	
}
