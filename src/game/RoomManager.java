package game;

import fixtures.*;

public class RoomManager {

	private Room[] rooms = new Room[7];
	protected Room startingRoom;

	public void init() {
		Room foyer = new Room(
				"The Foyer",
				"a small foyer",
				"The small entryway. A dining room is open to the west, where a large table can be seen." + "\n"
				+ "The hardwood floor leads east into the living room." + "\n"
				+ "To the north is a hall, where you can see the stairs to the second floor.",
				null);
		this.rooms[0] = foyer;
		this.startingRoom = foyer;
		
		Interactables hallItems[] = new Interactables[1];
		
		Interactables stairs = new Interactables(
				"Stairs",
				"use stairs",
				"You start taking steps to go up. As you reach the halfway point, someone comes and lets you know not to go to the second floor. \n" + 
				"You come back down the stairs to the hall."
				);
		hallItems[0] = stairs;
		
		Room hall = new Room(
				"The Hall",
				"a hall with stairs",
				"The pathway from the front of the house to the back. It connects each room on the floor. \n" + 
				"The floor is made of smooth tiles. To the east is a small open bar with some interesting things hanging off the wall",
				hallItems);
		this.rooms[1] = hall;
		
		Room livingRoom = new Room(
				"The Living Room",
				"a large living room",
				"This living room is huge. There is a large sofa with a short coffee table located directly in front of it. \n" +
				"There are 2 ceiling fans and a large screen TV along the wall facing the sofa.",
				null);
		this.rooms[2] = livingRoom;

		Room diningRoom = new Room(
				"The Dining Room",
				"a spacious dining room",
				"There is a wood table surrounded by 6 chairs and a chandelierhanging directly above the center of the table. \n" + 
				"A sideboard with 2 shelves above it are located alongside a wall. In the inside corner of there room is a fireplace.",
				null);
		this.rooms[3] = diningRoom;

		Room patio = new Room(
				"The Patio",
				"an open patio",
				"Outside is the patio with outdoor chairs and a table. There is a grill at the far end. \n" + 
				"There is a garden of plants surrounding the patio.",
				null);
		this.rooms[4] = patio;


		Interactables barItems[] = new Interactables[2];
		
		Interactables barStool = new Interactables(
				"Bar Stool",
				"take seat",
				"You pull out the barstool and plop right on it for a few minutes before getting back up."
				);
		
		Interactables flagCase = new Interactables(
				"Flag Case",
				"look closer",
				"You go up to the case and read what it says: \n" + 
				"In memory of JJ. A proud pilot for the United States military during WWII."
				);
		
		barItems[0] = barStool;
		barItems[1] = flagCase;
		
		Room bar = new Room(
				"The Bar",
				"an open bar",
				"The bar is just past the living room. As you can see, there are 3 bar stools, cooler, and a flag case with a black & white picture on it. \n" +
				"There appears to be something written under the picture.",
				barItems);
		this.rooms[5] = bar;

		Interactables kitchenItems[] = new Interactables[2];
		
		Interactables cookies = new Interactables(
				"Cookies",
				"eat cookies",
				"You go up to the island and grab some cookies to munch out as you continue to check out the kitchen."
				);
		
		Interactables flowers = new Interactables(
				"Flowers",
				"smell flowers",
				"You lean in to smell the flowers real quick."
				);
		
		kitchenItems[0] = cookies;
		kitchenItems[1] = flowers;

		Room kitchen = new Room(
				"The Kitchen",
				"a large kitchen",
				"Directly in the middle of the kitchen is an island. You see lights hanging over it. \n" + 
				"To the right is a fridge, stove, and dishwasher. To the left there are 2 ovens. \n" +
				"Above everything are the cabnets with a space above them to display china.",
				kitchenItems);
		this.rooms[6] = kitchen;
		
		
		
		foyer.setExits(hall, livingRoom, diningRoom, null);
		hall.setExits(patio, bar, kitchen, foyer);
		livingRoom.setExits(bar, null, foyer, null);
		diningRoom.setExits(kitchen, foyer, null, null);
		bar.setExits(null, null, hall, livingRoom);
		kitchen.setExits(null, hall, null, diningRoom);
		patio.setExits(null, null, null, hall);

	}










}
