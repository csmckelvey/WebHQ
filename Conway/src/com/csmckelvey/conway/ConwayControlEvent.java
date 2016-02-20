package com.csmckelvey.conway;

public class ConwayControlEvent {
	
	public static final int PLAY = 0;
	public static final int PAUSE = 1;
	public static final int ZOOM = 2;
	public static final int CHANGESHAPE = 3;
	public static final int CHANGESPEED = 4;
	public static final int SPEEDTEST = 5;
	
	private int event;
	private int eventModifier;
	
	public ConwayControlEvent(int event) {
		this(event, -1);
	}
	
	public ConwayControlEvent(int event, int eventModifier) {
		this.event = event;
		this.eventModifier = eventModifier;
	}
	
	public int getEvent() { 
		return this.event; 
	}
	
	public int getEventModifier() {
		return this.eventModifier; 
	}
	
	@Override
	public String toString() {
		return "ConwayControlEvent - Event: " + this.event + " Event Modifier: " + this.eventModifier;
	}
}
