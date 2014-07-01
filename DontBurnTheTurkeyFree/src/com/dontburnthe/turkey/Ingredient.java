package com.dontburnthe.turkey;
public class Ingredient {
	
	String name;
	Float quantity;
	boolean isMain = false;
	
	public Ingredient(String name, Float quantity, boolean isMain){
		this.name = name;
		this.quantity = quantity;
		this.isMain = isMain;
	}

}
