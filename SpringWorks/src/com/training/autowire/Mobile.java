package com.training.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	private Camera camera;
	private Screen screen;
	private Speaker speaker;
	public Mobile(Camera camera, Screen screen) {
		super();
		this.camera = camera;
		this.screen = screen;
	}
	public Mobile() {
		super();
	}
	public Camera getCamera() {
		return camera;
	}
	@Autowired
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public Screen getScreen() {
		return screen;
	}
	@Autowired
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	@Autowired
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
	
	
}
