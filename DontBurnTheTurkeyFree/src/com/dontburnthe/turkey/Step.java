package com.dontburnthe.turkey;

public class Step {
	
	String title;
	String desc;
	int time;
	int skipType;
	
	public Step(String title, String desc, int time, int skipType){
		this.title = title;
		this.desc = desc;
		this.time = time;
		this.skipType = skipType;
	}

}
