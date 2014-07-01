package com.dontburnthe.turkey;

import java.util.LinkedList;

public class Data {

	LinkedList<Recipe> recipes = new LinkedList<Recipe>();

	//1 = Prepare
	//2 = Time Critical - No warning
	//3 = Time Critical - Warning
	//4 = Complete

	public Data(){

		/*recipes.add(new Recipe("Reciepe name","meat,veg or extra"));
		recipes.getLast().addIngredient(new Ingredient("ingrediant name",wieght in grams, true if main ingrediant));
		recipes.getLast().addIngredient(new Ingredient("Sugar",10, false for all other ingrediant one true per reciepe));
		recipes.getLast().addStep(new Step("1st instruction title","1st instruction", time in mins));
		recipes.getLast().addStep(new Step("Prepare Carrots","Peel carrots and cut into slices. Then cover in vegetable oil and the sugar.", 10));
		recipes.getLast().addStep(new Step("Place Carrots in Oven and Cook","Put carrots into oven", 30));
		recipes.getLast().addStep(new Step("Remove Carrots","Preheat your oven to 200C celcius", 10));*/

		//Chicken
		recipes.add(new Recipe("Roast Chicken with White Wine Gravy","main",false));
		recipes.getLast().addIngredient(new Ingredient("Chicken",0f, true));
		recipes.getLast().addIngredient(new Ingredient("Softened butter",100f, false));
		recipes.getLast().addIngredient(new Ingredient("1 Onion",0f, false));
		recipes.getLast().addIngredient(new Ingredient("2 Bulbs of garlic",0f, false));
		recipes.getLast().addIngredient(new Ingredient("2 Lemons",0f, false));
		recipes.getLast().addIngredient(new Ingredient("6 Sprigs of fresh thyme",0f, false));
		recipes.getLast().addIngredient(new Ingredient("3 Sprigs of fresh rosemary",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Half a bottle of white wine",0f, false));
		recipes.getLast().addIngredient(new Ingredient("300ml Chicken stock",0f, false));
		recipes.getLast().addStep(new Step("Prepare Chicken", "Pat the skin of the chicken dry with some kitchen towel then massage about quarter of the butter into the skin of the bird not forgetting the legs. Cut one of the lemons in half and place it in the cavity of the bird together with 3 or 4 whole, unpeeled cloves of garlic.",15,1));
		recipes.getLast().addStep(new Step("Roast Chicken: Make flavoured butter", "Discard the tough central stem from two sprigs of the thyme and one of the rosemary, chop the pieces of herb  then mix them thoroughly with the remainder of the butter and season.",8,1));
		recipes.getLast().addStep(new Step("Roast Chicken: Flavour the bird", "Next, carefully ease your hand under the loose skin at the neck of the chicken and force this butter mixture under as far back as you can get, this will ensure the bird stays succulent. Finally, tuck a sprig of thyme in the both of the joints between the leg and body of the bird.",10,1));
		recipes.getLast().addStep(new Step("Roast Chicken: Prepare the tin", "Arrange the remaining sprigs of herbs and a few whole, unpeeled cloves of garlic where the chicken will go then place the bird on top of them.",5,1)); 
		recipes.getLast().addStep(new Step("Roast Chicken: Finishing touches before cooking", "Next, cut the onion into quarters and place them around the chicken in the roasting tray. Now chop the very top off of the bulb of garlic that you haven’t already split and remove as much of the papery skin as possible without separating the cloves from the main stem then place this in the pan too. Finally, pour in about half of the wine.",8,1));
		recipes.getLast().addStep(new Step("Roast the Chicken"," Place the chicken in the oven. Check occasionally and baste every 20 or so minutes adding more stock if there is no moisture in the bottom of the tray. If the chicken is browning too quickly then place a little foil over it.",0,3));
		recipes.getLast().addStep(new Step("Roast Chicken: Remove chicken", "Remove the chicken from the oven, cover in foil to keep it warm while it rests on another plate and you make the gravy.",15,1));
		recipes.getLast().addStep(new Step("Make the gravy", "Place the baking tray on the hob and heat to reduce and intensify the flavours, scraping the browned and burnt bits off of the bottom and sides of the pan.",7,1));
		recipes.getLast().addStep(new Step("Make the gravy", "Mix about two tablespoons of flour with some water. Now remove the herb sprigs and add the remaining wine, chicken stock and a little of the flour and water mixture. Cook until the gravy starts to thicken and add more flour and water if it is not thick enough. Season to taste and squeeze some of the roasted garlic out of their skins to add more flavour.",10, 4));

		//Pork
		recipes.add(new Recipe("Pork","main",false));
		recipes.getLast().addIngredient(new Ingredient("Pork",100f, true));
		recipes.getLast().addStep(new Step("Prepare Cabbage", "Remove the tough, fibrous stems from the middle of the cabbage leaves then cut into thin strips and rise.", 15,1));
		recipes.getLast().addStep(new Step("Cabbage: Boil cabbage ", "Tranfer prepared cabbage to a saucepan, cover with water, lightly salt and boil.",15,3));
		recipes.getLast().addStep(new Step("Cabbage: Remove from heat", "Remove cabbage from the heat and drain.",3,4));

		//Turkey
		recipes.add(new Recipe("Roast Turkey with Rich Gravy","main",false));
		recipes.getLast().addIngredient(new Ingredient("Turkey",0f, true));
		recipes.getLast().addIngredient(new Ingredient("Softened butter",150f, false));
		recipes.getLast().addIngredient(new Ingredient("2 Onions",0f, false));
		recipes.getLast().addIngredient(new Ingredient("2 Bulbs of garlic",0f, false));
		recipes.getLast().addIngredient(new Ingredient("1 Cooking apple",0f, false));
		recipes.getLast().addIngredient(new Ingredient("1 Cinnamon stick",0f, false));
		recipes.getLast().addIngredient(new Ingredient("1 Orange",0f, false));
		recipes.getLast().addIngredient(new Ingredient("6 Sprigs of fresh thyme",0f, false));
		recipes.getLast().addIngredient(new Ingredient("3 Sprigs of fresh rosemary",0f, false));
		recipes.getLast().addIngredient(new Ingredient("300ml Turkey stock",0f, false));
		recipes.getLast().addIngredient(new Ingredient("1 tbsp of redcurrant jelly",0f, false));
		recipes.getLast().addStep(new Step("Prepare Turkey", "Pat the skin of the turkey dry with some kitchen towel then massage about half of the butter and liberal amounts of salt into the skin of the bird not forgetting the legs.",8,1));
		recipes.getLast().addStep(new Step("Roast Turkey: Flavour the bird","Cut the orange in half and place on half in the cavity of the bird together with 3 or 4 whole, unpeeled cloves of garlic, the cinnamon stick and the chopped apple. Finally, tuck a sprig of thyme in the both of the joints between the leg and body of the bird ",14,1));
		recipes.getLast().addStep(new Step("Roast Turkey: Prepare the tin", "Arrange the remaining sprigs of herbs and a few whole, unpeeled cloves of garlic where the turkey will go then place the bird on top of them. Surround the bird with quarters of the onions, . ",8,1)); 
		recipes.getLast().addStep(new Step("Roast Turkey: Finishing touches before cooking", "Now chop the very top off of the bulb of garlic that you haven’t already split and remove as much of the papery skin as possible without separating the cloves from the main stem then place this in the pan too. Finally, pour in about half of the stock.",8,1));
		recipes.getLast().addStep(new Step("Roast the Turkey"," Place the turkey in the oven. Check occasionally and baste every 20 or so minutes adding more stock if there is no moisture in the bottom of the tray. If the Turkey is browning too quickly then place a little foil over it.",0,3));
		recipes.getLast().addStep(new Step("Roast Turkey: Remove turkey", "Remove the turkey from the oven, cover in foil to keep it warm while it rests on another plate and you make the gravy.",10,3));
		recipes.getLast().addStep(new Step("Make the gravy", "Place the baking tray on the hob and heat to reduce and intensify the flavours, scraping the browned and burnt bits off of the bottom and sides of the pan. Now remove the herb sprigs and orange..",15,3));
		recipes.getLast().addStep(new Step("Make the gravy", "Mix about three tablespoons of flour with some water. Add the remaining stock and a little of the flour and water mixture. Cook until the gravy starts to thicken and add more flour and water if it is not thick enough. Season to taste, squeeze some of the roasted garlic out of their skins to add more flavour and melt the redcurrant jelly into the gravy.",15, 4));

		//Gammon
		recipes.add(new Recipe("Clove Studded Gammon with Honey Marmalade Glaze","main",false));
		recipes.getLast().addIngredient(new Ingredient("Gammon",0f, true));
		recipes.getLast().addIngredient(new Ingredient("Orange juice to cover",150f, false));
		recipes.getLast().addIngredient(new Ingredient("40 Cloves",0f, false));
		recipes.getLast().addIngredient(new Ingredient("1 Onion",0f, false));
		recipes.getLast().addIngredient(new Ingredient("2 Bay leaves",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Brown sugar",120f, false));
		recipes.getLast().addIngredient(new Ingredient("3 Oranges",0f, false));
		recipes.getLast().addIngredient(new Ingredient("3 tsp Orange marmalade",0f, false));
		recipes.getLast().addIngredient(new Ingredient("3 tsp wholegrain",0f, false));
		recipes.getLast().addStep(new Step("Prepare Gammon: Remove some saltyness","Place the gammon into a large, deep pan and cover with water. Bring to the boil, then remove from the heat and drain.",15,3));
		recipes.getLast().addStep(new Step("Boil the Gammon","Return the gammon to the pan, then pour over enough orange juice to cover half and then enough cold water to cover the meat completely. Add 5 cloves, the onions cut in half and the bay leaves.",0,3));
		recipes.getLast().addStep(new Step("Gammon: Preheat the oven", "Turn the oven to 210c. ",2,1)); 
		recipes.getLast().addStep(new Step("Gammon: Remove the skin", "Drain the gammon, discarding the extras then carefully remove the skin leaving a fairly thin layer of fat.",15,3));
		recipes.getLast().addStep(new Step("Gammon: Make the glaze","Mix the sugar, marmalade and mustard together with the zest of two oranges and the juice of all three.",8,3));
		recipes.getLast().addStep(new Step("Bake the Gammon","Spoon half of the glaze over the ham and place in the preheated oven.",15,3));
		recipes.getLast().addStep(new Step("Bake the Gammon","Spoon the rest of the glaze over the ham replace in the oven and watch to ensure the meat does not burn, basting regularly. Remove the ham from the oven when it is golden and glistening.",25,3));
		recipes.getLast().addStep(new Step("Rest the Gammon","When the gammon has finished cooking, remove it from the oven, transfer it to a serving plate and leave it to rest for at least 15 mins, covered in cling if required hot.",25,3));

		//Beef
		recipes.add(new Recipe("Beef","main",false));
		recipes.getLast().addIngredient(new Ingredient("Beef",100f, true));
		recipes.getLast().addStep(new Step("Prepare Cabbage","Remove the tough, fibrous stems from the middle of the cabbage leaves then cut into thin strips and rise.", 15,1));
		recipes.getLast().addStep(new Step("Cabbage: Boil cabbage","Tranfer prepared cabbage to a saucepan, cover with water, lightly salt and boil.",15,1));
		recipes.getLast().addStep(new Step("Cabbage: Remove from heat","Remove cabbage from the heat and drain.",3,1));

		//plain cabbage
		recipes.add(new Recipe("Boiled Savoy Cabbage","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Savoy cabbage",100f, true));
		recipes.getLast().addStep(new Step("Prepare Cabbage","Remove the tough, fibrous stems from the middle of the cabbage leaves then cut into thin strips and rise.", 15,2));
		recipes.getLast().addStep(new Step("Cabbage: Boil cabbage","Tranfer prepared cabbage to a saucepan, cover with water, lightly salt and boil.",15,3));
		recipes.getLast().addStep(new Step("Cabbage: Remove from heat","Remove cabbage from the heat and drain.",3,4));

		//Cabbage:
		//Cabbahge with bacon lardons:
		recipes.add(new Recipe("Braised Savoy Cabbage with Bacon Lardons","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Savoy cabbage",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Smoked bacon lardons",25f, false));
		recipes.getLast().addIngredient(new Ingredient("Garlic",4f, false));//2 garlic cloves
		recipes.getLast().addIngredient(new Ingredient("White wine",15f, false));
		recipes.getLast().addIngredient(new Ingredient("Fennel seeds",0.8f, false));//teaspoon
		recipes.getLast().addIngredient(new Ingredient("Parsely",0.8f, false));//teaspoon
		recipes.getLast().addIngredient(new Ingredient("Creme freche",8f, false));//2tsps
		recipes.getLast().addStep(new Step("Prepare Cabbage","Remove the tough, fibrous stems from the middle of the cabbage leaves, cut into strips and rise.", 10,2));
		recipes.getLast().addStep(new Step("Cabbage: Fry the lardons","Heat a little oil in a wide pan then add the lardons and bacon. Stir occasionally until they are slightly browned on the edges", 10,3));
		recipes.getLast().addStep(new Step("Cabbage: Add the cabbage","Scrape the brown bits off of the bottom of the pan and add the cabbage, white wine, fennel seeds and parsley. Put the lid on and turn the heat right down. Check and turn occasionally.",15,3));
		recipes.getLast().addStep(new Step("Cabbage","Remove cabbage from the heat, season, stir in the creme freshe and then replace lid to keep the heat in.", 1,4));

		//cabbage with apricots and pecans

		recipes.add(new Recipe("Brandy Braised Savoy Cabbage with Apricots and Pecans","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Savoy cabbage",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Dried apricots",7.5f, false));//handful
		recipes.getLast().addIngredient(new Ingredient("Onion",75f, false));//quarter of an onion
		recipes.getLast().addIngredient(new Ingredient("Garlic",10f, false));//1garlic clove
		recipes.getLast().addIngredient(new Ingredient("Caraway seeds",1.25f, false));//tsp
		recipes.getLast().addIngredient(new Ingredient("Brandy",12.5f, false));
		recipes.getLast().addIngredient(new Ingredient("Pecan nuts, shelled",7.5f, false));//handful
		recipes.getLast().addStep(new Step("Cabbage: Soak apricots","Soak the apricots in just enough water to cover them and then slice thinly.",70,1));
		recipes.getLast().addStep(new Step("Prepare Cabbage","Remove the tough, fibrous stems from the middle of the cabbage leaves then cut into very thin strips and rise. Now dice onion and garlic.", 15,2));
		recipes.getLast().addStep(new Step("Cabbage: Fry the cabbage, onion and garlic.","Heat a little oil in a wide pan then add the cabbage, onion and garlic over a medium heat, stirring occasionally.", 7,3));
		recipes.getLast().addStep(new Step("Cabbage: Add apricots","Add the apricots, caraway seeds, brandy and a pinch of salt to the softened cabbage and bring to the boil.",5,3));
		recipes.getLast().addStep(new Step("Cabbage: Simmer","When boiling turn the heat down too low, cover loosely with baking parchment and simmer , stirring occasionally .",10,3));
		recipes.getLast().addStep(new Step("Cabbage","Don’t forget to stir the cabbage!",10,1));
		recipes.getLast().addStep(new Step("Cabbage: Add the pecans","Gently stir in the pecans and then serve.",2,4)); 

		//Plain carrots:

		recipes.add(new Recipe("Boiled Carrots","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Carrots",60f, true));
		recipes.getLast().addStep(new Step("Prepare Carrots","Top and tail the carrots. Peel if desired and cut into either batons or coins.", 15,1));
		recipes.getLast().addStep(new Step("Carrots: Boil carrots","Transfer prepared carrots to a saucepan, cover with water, lightly salt and bring to the boil.",20,3));
		recipes.getLast().addStep(new Step("Carrots: Remove from heat","Remove carrots from the heat and drain.",3,4));

		//Carrots:
		//Honey and thyme glazed carrots

		recipes.add(new Recipe("Honey and Thyme Glazed Baby Carrots","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Carrots",75f, true));
		recipes.getLast().addIngredient(new Ingredient("Honey",5f, false));//ml
		recipes.getLast().addIngredient(new Ingredient("Thyme",1f, false));//sprig
		recipes.getLast().addStep(new Step("Prepare Carrots","Scrub the carrots to remove any excess dirt and then cut the tops and bottoms off them.",15,1));
		recipes.getLast().addStep(new Step("Carrots: Boil carrots","Place carrots in a pan which is big enough to stop the carrots being piled more than two or three deep and cover with cold water. To the water add the honey, butter and thyme, as well as a pinch of salt, then bring to a gentle boil.", 15,3));
		recipes.getLast().addStep(new Step("Carrots: Check carrots","Have a look at the carrots now, there should be about a tablespoon of liquid left,.", 3,1));
		recipes.getLast().addStep(new Step("Carrots: Check carrots","There should now be about a tablespoon of liquid left, if this is the case then remove from the heat and press 'done' but if not then leave to cook for a further 5 minutes.",2,1));
		recipes.getLast().addStep(new Step("Carrots: Check carrots","There should now be about a tablespoon of liquid left so remove from the heat.", 2,4));

		//spiced carrots

		recipes.add(new Recipe("Sweetly Spiced Roast Carrots","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Carrots",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Honey",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Cumin",1f, false));//tsp
		recipes.getLast().addIngredient(new Ingredient("Coriander",1f, false));//tsp
		recipes.getLast().addIngredient(new Ingredient("Brown sugar",1f, false));//tsp
		recipes.getLast().addStep(new Step("Prepare Carrots","Peel and trim carrots then cut in half lengthways or into quarters if especially large .",15,1));
		recipes.getLast().addStep(new Step("Carrots: Parboil carrots","Place carrots in a saucepan, cover with boiling water and boil.", 12,3)); 
		recipes.getLast().addStep(new Step("Carrots: Mix spices","In a small bowl mix the honey, olive oil and spices.", 2,1));
		recipes.getLast().addStep(new Step("Carrots: Bake carrots","Remove carrots from the heat and drain. Now transfer to a baking tray and pour over the spice and honey mixture, then toss the carrots to ensure they are entirely covered. Now put the carrots in the oven.", 3,1));
		recipes.getLast().addStep(new Step("Carrots: Check carrots","Toss the carrots so all sides are covered in oil again- you may need to add more oil- and sprinkle over the sugar. Replace in oven.",20,3));
		recipes.getLast().addStep(new Step("Carrots: Check carrots","Give the carrots another toss in their oil.", 10,1));
		recipes.getLast().addStep(new Step("Carrots: Remove carrots","Take the carrots out of the oven.", 3,4));

		//plain sprouts

		recipes.add(new Recipe("Boiled Brussels Sprouts","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Sprouts",80f, true));
		recipes.getLast().addStep(new Step("Prepare Sprouts","Remove the hard stalk at the bottom of the sprouts and cut crosses about half a centimetre deep in their bases.", 20,1));
		recipes.getLast().addStep(new Step("Sprouts: Boil Sprouts","Transfer prepared sprouts to a saucepan, cover with water, lightly salt and bring to the boil.",25,3));
		recipes.getLast().addStep(new Step("Sprouts: Remove from heat","Remove sprouts from the heat and drain.",3,4));

		//Sprouts
		//garlic and lemon sprout

		recipes.add(new Recipe("Caramelised Garlic and Lemon Sprouts","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Sprouts",80f, true));
		recipes.getLast().addIngredient(new Ingredient("Garlic cloves",40f, false));//half a head
		recipes.getLast().addIngredient(new Ingredient("Olive oil",40f, false));//ml
		recipes.getLast().addIngredient(new Ingredient("Balsamic vinegar",5f, false));//ml
		recipes.getLast().addIngredient(new Ingredient("Sugar",15f, false));
		recipes.getLast().addIngredient(new Ingredient("Red chilli (optional)",15f, false));
		recipes.getLast().addIngredient(new Ingredient("Parmesan" ,15f, false));
		recipes.getLast().addIngredient(new Ingredient("Lemon zest",25f, false));//tsp
		recipes.getLast().addIngredient(new Ingredient("Basil leaves",5f, false));
		recipes.getLast().addStep(new Step("Sprouts: Prepare garlic","Peel the garlic and put it in a pan. Whilst you do this, put the kettle on with enough water in it for about two cups of tea.",8,1));
		recipes.getLast().addStep(new Step("Sprouts: Prepare garlic","Cover the garlic with boiling water and boil vigorously.",4,3));
		recipes.getLast().addStep(new Step("Sprouts: Fry garlic","Drain the garlic, dry the pan and fry half of the olive oil on a high heat, stirring until browned on all sides.", 8,1)); 
		recipes.getLast().addStep(new Step("Sprouts: Caramelise garlic","Add the vinegar, a tablespoon of sugar, the water and some salt. Bring to a boil and simmer on medium heat.",5,1));
		recipes.getLast().addStep(new Step("Sprouts: Check caramelised garlic","By now most of the water should have evaporated leaving just the cloves in a syrup, if it has then press 'skip', if not then leave on the heat.", 3,1));
		recipes.getLast().addStep(new Step("Sprouts: Check caramelised garlic","By now most of the water should have evaporated leaving just the cloves in a syrup, if it has then remove from the heat and set aside.", 2,1));
		recipes.getLast().addStep(new Step("Prepare Sprouts"," Trim the bases off the sprouts and cut them top to bottom into halves.", 15,1));
		recipes.getLast().addStep(new Step("Sprouts: Fry sprouts"," Heat the other half of the oil in a large, heavy-based pan, sprouts, season and cook on high heat, stirring them once or twice, but not too often, so that they char well without breaking up; add extra oil if needed.",10,3));
		recipes.getLast().addStep(new Step("Finish the Sprouts","Roughly chop the chilli and basil. Stir these in with the parmesan and lemon zest then season and add oil if necessary", 15,4));

		//bacon and chestnut sprouts
		recipes.add(new Recipe("Brussels Sprouts with Chestnuts and Bacon","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Sprouts",85f, true));
		recipes.getLast().addIngredient(new Ingredient("Streaky bacon",10f, false));//
		recipes.getLast().addIngredient(new Ingredient("Chestnuts",10f, false));
		recipes.getLast().addIngredient(new Ingredient("Chicken stock",40f, false));//ml
		recipes.getLast().addStep(new Step("Prepare Sprouts"," Prepare the sprouts by removing the outer skin and cutting the root off. If too large, slice in half.",15,1));
		recipes.getLast().addStep(new Step("Sprouts: Heat stock","Heat the stock until it reaches a vigorous boil then add the sprouts and cook.",20,3));
		recipes.getLast().addStep(new Step("Sprouts: Fry bacon and chestnuts","Roughly chop the bacon and chestnuts into chunky pieces and fry until brown on the edges.", 10,1));
		recipes.getLast().addStep(new Step("Sprouts: Mix everything together","Now mix stir the bacon and chestnuts into the sprouts carefully and fry for another minute or two, to heat the sprouts though.", 8,4));

		//brocilli
		recipes.add(new Recipe("Boiled Broccoli","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Broccoli",90f, true));
		recipes.getLast().addStep(new Step("Prepare Broccoli","Cut the broccoli florets from the hard centeral stem .", 7,1));
		recipes.getLast().addStep(new Step("Broccoli: Boil Broccoli","Transfer prepared broccoli to a saucepan, cover with water, lightly salt and bring to the boil.",25,3));
		recipes.getLast().addStep(new Step("Broccoli: Remove from heat","Remove broccoli from the heat and drain.",3,4));

		//cauliflour
		recipes.add(new Recipe("Boiled Cauliflower","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Cauliflower",90f, true));
		recipes.getLast().addStep(new Step("Prepare Cauliflower","Cut the cauliflower florets from the hard centeral stem .", 7,1));
		recipes.getLast().addStep(new Step("Cauliflower: Boil cauliflower","Transfer prepared cauliflower to a saucepan, cover with water, lightly salt and bring to the boil.",25,3));
		recipes.getLast().addStep(new Step("Cauliflower: Remove from heat","Remove cauliflower from the heat and drain.",3,4));

		//peas
		recipes.add(new Recipe("Minted Peas","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Peas",90f, true));
		recipes.getLast().addIngredient(new Ingredient("Mint",10f, true));//1 sprig
		recipes.getLast().addIngredient(new Ingredient("Sugar",25f, true));//1tbsp
		recipes.getLast().addStep(new Step("Prepare Peas","If fresh peas, then shell.", 12,1));
		recipes.getLast().addStep(new Step("Peas: Boil Peas","Transfer prepared peas and sugar to a saucepan, cover with water, lightly salt and bring to the boil.",6,1));
		recipes.getLast().addStep(new Step("Peas: Remove from heat","Remove peas from the heat and drain.",3,4));

		//sweet potatoes 
		recipes.add(new Recipe("Roasted Sweet Potatoes","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Sweet Potatoe",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Honey",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Prepare Sweet Potatoe","Peel sweet potato then cut into battons about 1cm thick.",15,1));
		recipes.getLast().addStep(new Step("Sweet Potatoes: Parboil potatoes","Place the chopped potatoes in a saucepan, cover with boiling water and boil.", 12,1)); 
		recipes.getLast().addStep(new Step("Sweet Potatoes: Bake potatoes","Remove potatoes from the heat and drain. Now transfer to a baking tray and drizzle over the honey, then toss them to ensure they are entirely covered with both honey and oil. Now put the the potatoes in the oven.", 25,3));
		recipes.getLast().addStep(new Step("Sweet Potatoes: Check potatoes","Toss the potatoes so all sides are covered in oil again then replace in oven.",28,3));
		recipes.getLast().addStep(new Step("Sweet Potatoes: Check potatoes","Give the potatoes another toss in their oil.", 10,1));
		recipes.getLast().addStep(new Step("Sweet Potatoes: Remove potatoes","Take the potatoes out of the oven.", 3,4));

		//butternut squash
		recipes.add(new Recipe("Roasted Butternut Squash","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Butternut squash",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Dried sage",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Prepare Butternut Squash","Carefully peel squash and cut into medium sized chunks.",20,1));
		recipes.getLast().addStep(new Step("Butternut Squash: Parboil squash","Place the chopped squash in a saucepan, cover with boiling water and bring to a vigorous boil.", 12,2)); 
		recipes.getLast().addStep(new Step("Butternut Squash: Bake squash","Remove squash from the heat and drain. Now transfer to a baking tray and sprinkle over the sage, then toss them to ensure they are entirely covered with both the herbs and oil. Now put the the squash in the oven.", 27,3));
		recipes.getLast().addStep(new Step("Butternut Squash: Check squash","Toss the squash so all sides are covered in oil again then replace in oven.",22,3));
		recipes.getLast().addStep(new Step("Butternut Squash: Check squash","Give the squash another toss in their oil and continue to cook.", 12,3));
		recipes.getLast().addStep(new Step("Butternut Squash: Remove squash","Take the squash out of the oven.", 3,4));

		//Sweede
		recipes.add(new Recipe("Roasted Swede","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Swede",80f, true));
		recipes.getLast().addIngredient(new Ingredient("Dried sage",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Prepare Swede","Carefully peel swede and cut into medium sized chunks.",20,1));
		recipes.getLast().addStep(new Step("Swede: Parboil swede","Place the chopped swede in a saucepan, cover with boiling water and bring to a vigorous boil.", 12,2)); 
		recipes.getLast().addStep(new Step("Swede: Bake swede","Remove swede from the heat and drain. Now transfer to a baking tray and sprinkle over the sage, then toss them to ensure they are entirely covered with both the herbs and oil. Now put the the squash in the oven.", 21,3));
		recipes.getLast().addStep(new Step("Swede: Check swede","Toss the swede so all sides are covered in oil again then replace in oven.",29,3));
		recipes.getLast().addStep(new Step("Swede: Check swede","Give the swede another toss in their oil and continue to cook.", 12,3));
		recipes.getLast().addStep(new Step("Swede: Remove swede","Take the swede out of the oven.", 3,4));

		//roasted courggete
		recipes.add(new Recipe("Baked Courgette","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Courgette",80f, true));
		recipes.getLast().addIngredient(new Ingredient("Dried parsely",25f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Prepare Courgette","Cut the courgette on a diagonal in to slices of medium thickness.",10,1));
		recipes.getLast().addStep(new Step("Courgette: Bake courgette","Arrange the courgette on a baking tray and sprinkle over the parsely, then toss them to ensure they are entirely covered with both the herbs and oil. Now put the the courgette in the oven.", 35,3));
		recipes.getLast().addStep(new Step("Courgette: Check courgette","Give the courgette another toss in their oil and continue to cook.", 15,3));
		recipes.getLast().addStep(new Step("Courgette: Remove courgette","Take the courgette out of the oven.", 3,4));

		//courgette gratin
		recipes.add(new Recipe("Baked Courgette and Tomato Gratin","veg",true));
		recipes.getLast().addIngredient(new Ingredient("Courgette",150f, true));
		recipes.getLast().addIngredient(new Ingredient("Red onion",75f, false));
		recipes.getLast().addIngredient(new Ingredient("Plum tomatoes",150f, false));
		recipes.getLast().addIngredient(new Ingredient("Bread crumbs",80f, false));
		recipes.getLast().addIngredient(new Ingredient("Parmesan",50f, false));
		recipes.getLast().addIngredient(new Ingredient("Fresh basil",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Oregano",75f, false));
		recipes.getLast().addIngredient(new Ingredient("Stock",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Gratin: Slice vegetables","Slice the courgette and tomatoes in to 2cm rounds.", 15,2)); 
		recipes.getLast().addStep(new Step("Gratin: Fry onions","Slice the onion and fry in a little olive oil until browned.",12,1));
		recipes.getLast().addStep(new Step("Gratin: Arrange vegetables","Arrange the courgette and tomatoes in alternate layers on top of the onions, adding some of the torn up basil leaves and a little oregano as you go, until the dish is full.", 21,1));
		recipes.getLast().addStep(new Step("Gratin: Add the topping","Sprinkle with more of the basil and oregano on top to the vegetables then pour over enough stock to come about a quarter of the way up the dish. Next mix the grated parmesan, breadcrumbs and a liberal amount of seasoning and arrange on the top of the gratin.",15,1));
		recipes.getLast().addStep(new Step("Gratin: Cook the gratin","Place the gratin the oven until cooked and bubbling.", 45,3));
		recipes.getLast().addStep(new Step("Gratin: Cook the gratin","Remove gratin from oven.", 5,4));

		//sweetcorn 
		recipes.add(new Recipe("Buttered Sweetcorn","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Sweetcorn",90f, true));
		recipes.getLast().addIngredient(new Ingredient("Sugar",25f, true));//1tbsp
		recipes.getLast().addIngredient(new Ingredient("Butter",25f, true));//1tbsp
		recipes.getLast().addStep(new Step("Sweetcorn: Boil Peas","Put the sweetcorn in a saucepan, cover with water, the sugar, lightly salt and bring to the boil.",4,1));
		recipes.getLast().addStep(new Step("Sweetcorn: Remove from heat","Remove sweetcorn from the heat and drain then place the knob of butter on top.",3,4));	

		//parsnip
		recipes.add(new Recipe("Roasted Parsnips ","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Parsnips",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Brown sugar",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Olive oil",25f, false));//tbsp
		recipes.getLast().addStep(new Step("Prepare Parsnips ", "Peel and trim parsnips then cut in half lengthways or into quarters if especially large .",15,2));
		recipes.getLast().addStep(new Step("Parsnips: Parboil parsnips", "Place parsnips in a saucepan, cover with boiling water and boil.", 12,3)); 
		recipes.getLast().addStep(new Step("Parsnips: Bake parsnips ", "Remove parsnips from the heat and drain. Now transfer to a baking tray and sprinkle with brown sugar, then toss the parsnips to ensure they are entirely covered. Now put the parsnips in the oven. ", 3,1));
		recipes.getLast().addStep(new Step("Parsnips: Check parsnips", "Toss the Parsnipss so all sides are covered in oil again- you may need to add more oil- and sprinkle over the sugar. Replace in oven.",20,3));
		recipes.getLast().addStep(new Step("Parsnips: Check parsnips", "Give the parsnips another toss in their oil and continue cooking.", 10,3));
		recipes.getLast().addStep(new Step("Parsnips: Remove parsnips", "Take the parsnips out of the oven.", 3,4));

		//roasted pots
		recipes.add(new Recipe("Extra Crispy Roasted Potatoes ","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Potatoes",100f, true));
		recipes.getLast().addIngredient(new Ingredient("Olive oil",25f, false));//tbsp
		recipes.getLast().addStep(new Step("Prepare Potatoes ", "Peel potatoes then cut in to medium sized pieces.",15,1));
		recipes.getLast().addStep(new Step("Potatoes: Parboil Potatoes", "Place potatoes in a saucepan, cover with boiling water and boil.", 12,3)); 
		recipes.getLast().addStep(new Step("Potatoes: Prepare for baking", "Remove potatoes from the heat and drain. Holding the lid on tightly, shake the pan with the potatoes inside vigorously untill the edges are scuffed and battered.", 3,1));
		recipes.getLast().addStep(new Step("Potatoes: Bake potatoes", "Transfer to a baking tray and sprinkle with brown sugar, then toss the potatoes to ensure they are entirely covered. Now put them in the oven.",35,3));	
		recipes.getLast().addStep(new Step("Potatoes: Check Potatoes", "Turn the potatoes so all sides are once again covered in oil. Replace in oven and continue to cook.",30,3));
		recipes.getLast().addStep(new Step("Potatoes: Check Potatoes", "Give the potatoes another toss in their oil and continue to cook.", 10,3));
		recipes.getLast().addStep(new Step("Potatoes: Remove potatoes", "Take the potatoes out of the oven.", 3,4));


		//fennel
		recipes.add(new Recipe("Roasted Fennel","veg",false));
		recipes.getLast().addIngredient(new Ingredient("Fennel",70f, true));
		recipes.getLast().addIngredient(new Ingredient("Balsamic vinegar",0f, false));//tbsp
		recipes.getLast().addIngredient(new Ingredient("Olive oil",0f, false));
		recipes.getLast().addStep(new Step("Prepare Fennel ", "Cut the base off of the fennel bulbs, and cut a cone shape into the base to remove the core. You can see the core because it is whiter than the surrounding green.",15,2));
		recipes.getLast().addStep(new Step("Fennel: Bake fennel", "Transfer to a baking tray and sprinkle over the balsamic vinegar, then toss them to ensure they are entirely covered with both the vinegar and oil. Now put the the fennel in the oven. ", 20,3));
		recipes.getLast().addStep(new Step("Fennel: Check fennel", "Toss the fennel so all sides are covered in oil again then replace in oven.",25,3));
		recipes.getLast().addStep(new Step("Fennel: Remove fennel", "Take the fennel out of the oven.", 3,4));

		//Gravy LEAVE IN TO FILL SPACE
		recipes.add(new Recipe("Gravy","extras",false));
		recipes.getLast().addIngredient(new Ingredient("16 Cocktail sausages",0f, false));
		recipes.getLast().addIngredient(new Ingredient("8 Rashers of streaky bacon",0f, false));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Prepare bacon", "Cut the rashers of bacon in half and remove any rind. Now using the back of knife gentally streach the bacon to make it thinner.",15,1));
		recipes.getLast().addStep(new Step("Prepare Piglets in Blankets", "Wrap the sauseages in the streached bacon.",5,1));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Bake Piglets", "Place the sausages on a lightly greased tray and place in the oven", 30,3));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Remove Piglets", "Take the piglets in blankets out of the oven", 3,4));

		//Bread sauce 
		recipes.add(new Recipe("Bread Sauce","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Stale bread",150f,true));
		recipes.getLast().addIngredient(new Ingredient("Onion",1f, false));//1 
		recipes.getLast().addIngredient(new Ingredient("Whole cloves",17f, false));//1
		recipes.getLast().addIngredient(new Ingredient("Whole peppercorns",9f, false));//8-10
		recipes.getLast().addIngredient(new Ingredient("Bay leaf",0f, false));//1
		recipes.getLast().addIngredient(new Ingredient("Milk",570f, false));//ml
		recipes.getLast().addIngredient(new Ingredient("Butter",50f, false));
		recipes.getLast().addIngredient(new Ingredient("Cream",50f, false));//ml
		recipes.getLast().addStep(new Step("Bread Sauce: Make breadcrumbs","Cut the crusts off of the bread and use a food processor to make medium sized breadcrumbs. If you don’t have a food processer then grate extra stale bread with a cheese grater.", 15,1 ));
		recipes.getLast().addStep(new Step("Bread Sauce: Flavour the milk","Cut the onion in half and remove the brown skin. Stud these onion halves with the cloves- pushing them right in so that they don’t fall out- and add them to the milk together with the bay leaf and peppercorns.",10,1));
		recipes.getLast().addStep(new Step("Bread Sauce: Infuse the milk","Bring the milk to the boil with the onion and spices then remove from heat, cover and leave in a warm place to allow the flavours to develop.",120,3));
		recipes.getLast().addStep(new Step("Bread Sauce: Thicken the sauce","Remove the onions and spices from the milk and put to one side. Stir the breadcrumbs and half of the butter (25g) into the milk and then heat very gently, stirring from time to time.",25,3));
		recipes.getLast().addStep(new Step("Bread Sauce: Infuse again","The sauce should have thickened by now, so remove it from the heat and replace the clove studded onion and bay leaf. Leave everything to infuse a little more in a warm place with the lid on.",60,3));
		recipes.getLast().addStep(new Step("Bread Sauce: Finishing touches","Remove the onion and bay leaf and discard. Reheat gently on a low heat and beat in the remaining 25g of butter and the cream, then taste to check the seasoning.",60,3));
		recipes.getLast().addStep(new Step("Bread Sauce: Completed","Remove from heat and leave to one side to cool.",5,4));

		//cranberry sauce
		recipes.add(new Recipe("Cranberry and Port Sauce with Star Anise","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Cranberries",250f, true));
		recipes.getLast().addIngredient(new Ingredient("Orange zest of one orange",0f, false));//1 
		recipes.getLast().addIngredient(new Ingredient("Orange juice",350f, false));//ml
		recipes.getLast().addIngredient(new Ingredient("Redcurrant jelly",50f, false));//2tbsp
		recipes.getLast().addIngredient(new Ingredient("Port",150f, false));//
		recipes.getLast().addIngredient(new Ingredient("Star anise",1f, false));//one piece
		recipes.getLast().addIngredient(new Ingredient("Sugar",50f, false));
		recipes.getLast().addStep(new Step("Cranberry Sauce: Mix everything together"," Tip the cranberries into a saucepan, grate in the orange zest then squeeze in the juice. Add the redcurrant jelly, port and star anise and stir.",8,1));
		recipes.getLast().addStep(new Step("Cranberry Sauce: Simmer","Cover and bring this mixture to a simmer, stirring gently and occasionally.",15,3));
		recipes.getLast().addStep(new Step("Cranberry Sauce: Remove from heat","Remove from the heat and taste, add as much sugar as needed. Don’t forget to remove the star anise.",8,4));		

		//stuffing
		recipes.add(new Recipe("Adaptable Stuffing ","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Onion",0f, false));//1 whole
		recipes.getLast().addIngredient(new Ingredient("Bacon",75f, false));
		recipes.getLast().addIngredient(new Ingredient("Garlic",0f, false));//2cloves 
		recipes.getLast().addIngredient(new Ingredient("Sausage meat",450f, true));
		recipes.getLast().addIngredient(new Ingredient("Sage",15f, false));
		recipes.getLast().addIngredient(new Ingredient("Parsely",15f, false));//
		recipes.getLast().addIngredient(new Ingredient("Fresh breadcrumbs",75f, false));
		recipes.getLast().addIngredient(new Ingredient("1 egg",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Optional extra flavourings such as chopped dried apricots, cranberries, walnuts, prunes or orange zest ",0f, false));
		recipes.getLast().addStep(new Step("Prepare Stuffing ", "Dice and fry the onions, bacon and garlic.",15,1));
		recipes.getLast().addStep(new Step("Stuffing: Mix everything", "Place the fried onions, garlic and bacon on a kitchen towel to drain off the excess fat, then mix with the chopped herbs, sausage meat, egg and breadcrumbs as well as any additional ingredients and season. Now mix by squeezing through your hands until well combined .",18,1));
		recipes.getLast().addStep(new Step("Stuffing: Taste for seasoning", "Fry a small amount of the prepared mixture to check for seasoning and adjust as necessary . Repeat until you are happy with the flavour.",20,3));
		recipes.getLast().addStep(new Step("Stuffing: Shape stuffing", "Now shape the stuffing in to spheres roughly the same size as ping-pong balls.", 3,1));
		recipes.getLast().addStep(new Step("Stuffing: Bake stuffing", "Place the balls on a lightly greased tray and place in the oven", 40,3));
		recipes.getLast().addStep(new Step("Stuffing: Remove stuffing", "Take the stuffing out of the oven", 3,4));

		//piglets in blankets
		recipes.add(new Recipe("Piglets in Blankets ","extras",false));
		recipes.getLast().addIngredient(new Ingredient("16 Cocktail sausages",0f, false));
		recipes.getLast().addIngredient(new Ingredient("8 Rashers of streaky bacon",0f, false));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Prepare bacon", "Cut the rashers of bacon in half and remove any rind. Now using the back of knife gentally streach the bacon to make it thinner.",15,1));
		recipes.getLast().addStep(new Step("Prepare Piglets in Blankets", "Wrap the sauseages in the streached bacon.",5,1));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Bake Piglets", "Place the sausages on a lightly greased tray and place in the oven", 30,3));
		recipes.getLast().addStep(new Step("Piglets in Blankets: Remove Piglets", "Take the piglets in blankets out of the oven", 3,4));

		//apple sauce
		recipes.add(new Recipe("Apple Sauce","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Cooking apples",225f, true));
		recipes.getLast().addIngredient(new Ingredient("Sugar",0f, false));//to taste
		recipes.getLast().addIngredient(new Ingredient("Lemon zest",25f, true));//zest of 1 lemon
		recipes.getLast().addIngredient(new Ingredient("Sage",15f, true));//1tsp
		recipes.getLast().addIngredient(new Ingredient("Butter",25f, true));//1tbsp
		recipes.getLast().addStep(new Step("Prepare Apples","Peel, core and roughly chop the apples.",10,1));
		recipes.getLast().addStep(new Step("Apple Sauce: Heat sauce","Place the apples in a pan togther with a splash of water, the zest of one lemon and a pinch of the sage.",3,1));
		recipes.getLast().addStep(new Step("Apple Sauce: Heat sauce","Stir in the butter and sugar to taste.",6,4));

		//yorkshire puddings
		recipes.add(new Recipe("Yorkshire Puddings ","extras",false));
		recipes.getLast().addIngredient(new Ingredient("3 Eggs",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Flour",115f, false));
		recipes.getLast().addIngredient(new Ingredient("Milk",275f, false));//ml 
		recipes.getLast().addIngredient(new Ingredient("Lard",0f, false));
		recipes.getLast().addStep(new Step("Yorkshire Puddings: Make batter ", "Beat all of the ingredients together with a pinch of salt. Cover with cling and place the mixture in the fridge to rest.",40,2));
		recipes.getLast().addStep(new Step("Yorkshire Puddings: Heat oil", "Grease a baking tin with a little lard and some oil. Place in the oven to heat. ",15,1));
		recipes.getLast().addStep(new Step("Yorkshire Pudding: Bake puddings", "Remove the heated oil from the oven and carefully pour the batter into the tray then replace in the oven. Whilst the puddings are cooking try not to open the oven door.", 20,3));
		recipes.getLast().addStep(new Step("Yorkshire Pudding: Remove puddings", "Remove the puddings from the oven.", 40,3));

		//redcurrent
		recipes.add(new Recipe("Redcurrant Jelly","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Redcurrants",500f, false));
		recipes.getLast().addIngredient(new Ingredient("500ml Water ",0f, true));
		recipes.getLast().addIngredient(new Ingredient("450g per 500ml of juice extracted of caster sugar",0f, false));
		recipes.getLast().addStep(new Step("Redcurrant Jelly: Sterilise jars", "This recipe makes more jelly than you will need on the day but the ratios are 1:1 sugar and currants plus the sugar thus easily adaptable. For the amount listed, you will need to sterilise some jars so that the jelly doesn’t go mouldy when kept. To do this, simply wash in very hot water then place in the oven at 100’c or hotter until needed.",10,1));
		recipes.getLast().addStep(new Step("Redcurrant Jelly: Simmer currants ", "Wash the fruit then place in a large pan with the water and bring to the boil. Stir and mash a little from time to time.",35,3)); 
		recipes.getLast().addStep(new Step("Redcurrant Jelly: Strain the currants", "If you have a jelly bag and frame then use that but otherwise use a loose-weave fabric you don’t mind being stained, such as a jay-cloth or a piece of muslin. Place over a bowl and tip in the contents of the pan then draw the corners together and tie. Suspend this over the bowl to catch the liquid. Do not squeeze as this will make the jelly cloudy.", 120,3));
		recipes.getLast().addStep(new Step("Redcurrant Jelly: Add sugar", "Calculate the amount of sugar needed and add it to the liquid then boil for 8 minutes. Whilst this is happening, remove the jars from the oven to cook slightly.",12,3));
		recipes.getLast().addStep(new Step("Redcurrant Jelly: Jar the jelly", "Carefully pour the redcurrant jelly into the heated jars, everything will be really hot so be sure not to burn your hands or touch the mixture. Place a small circle of thick paper over the top of the jelly to prevent mould then swrew the lids on tightly whilst still hot.", 45,4));

		//horseradish sauce
		recipes.add(new Recipe("Horseradish Sauce","extras",false));
		recipes.getLast().addIngredient(new Ingredient("Fresh horseradish",15f, true));
		recipes.getLast().addIngredient(new Ingredient("1 tbsp White wine vinegar",0f, false));
		recipes.getLast().addIngredient(new Ingredient("Pinch of mustard powder",0f, false));//ml 
		recipes.getLast().addIngredient(new Ingredient("Pinch of caster sugar",0f, false));
		recipes.getLast().addIngredient(new Ingredient("150ml Double cream",150f, false));
		recipes.getLast().addStep(new Step("Horseradish Sauce: Prepare horseradish ", "Put the kettle on then trim, peel and grate the horseradish. Now grate the horseradish and place in to a bowl of boiling water. ",15,1));
		recipes.getLast().addStep(new Step("Horseradish Sauce: Make the base", "Whip the double cream until it forms soft peaks then fold in the vinegar, mustard powder and sugar using a metal spoon and a figure of eight motion.",15,1));
		recipes.getLast().addStep(new Step("Horseradish Sauce: Add horseradish", "Drain the horseradish and remove the excess oil with kitchen towels. Using the same folding motion fold this into the cream mixture.",10,4));

	}
}
