package com.dontburnthe.turkey;

import java.util.LinkedList;

public class Recipe {
	
	String name;
	int totalTime;
	LinkedList<Ingredient> usedIngre = new LinkedList<Ingredient>();
	String section;
	Ingredient mainIngre;
	LinkedList<Step> steps = new LinkedList<Step>();
	boolean isPremium;
	
	boolean first = true;
	
	public Recipe(String name, String section, boolean isPremium){
		this.name = name;
		this.isPremium = isPremium;
		this.section = section;
	}
	
	public void addStep(Step step){
		steps.add(step);
		
		totalTime = 0;
		
		for(int i = 0; i<steps.size(); i++){
			totalTime = totalTime + steps.get(i).time;
		}
	}
	
	public void addIngredient(Ingredient ingre){
		if(first == true){
			mainIngre = ingre;
			first = false;
		}
		
		usedIngre.add(ingre);
	}
	
	
	
}
