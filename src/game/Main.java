package game;

import java.util.Scanner;

public class Main {


	static String[] input =  new String[2];
	static Scanner sc = new Scanner(System.in);
	static RoomManager roomManager = new RoomManager();
	static String directions = "north south east west";

	public static void main(String[] args) {
		roomManager.init();
		Player player = new Player(roomManager.startingRoom);
		Boolean runGame = true;
		
		System.out.println("Welcome to the Stowe household. Come right in. The first area of the house you'll be walking into is the foyer. \n \n");

		printRoom(player);
		
		while(runGame != false) {
			collectInput();
			parse(input, player);

		}

	}

	private static void printRoom(Player player) {

		System.out.println(player.getCurrentRoom().name + "\n" + "\n");
		System.out.println(player.getCurrentRoom().longDescription + "\n");

		printOptions(player);

	}

	private static void printOptions(Player player) {

		if(player.getCurrentRoom().getItems() != null) {
			System.out.println("Interactable Items: \n");
			for (int i =0; i < player.getCurrentRoom().getItems().length; i++) {
				System.out.println(player.getCurrentRoom().getItems()[i].getName());
				System.out.println("Command: " + player.getCurrentRoom().getItems()[i].getDirections() + "\n");

			}
		}


		System.out.println("Exits:");

		if(player.getCurrentRoom().getExit("north") != null)
			System.out.println("north: " + player.getCurrentRoom().getExit("north").getShortDescription());

		if(player.getCurrentRoom().getExit("east") != null)
			System.out.println("east: " + player.getCurrentRoom().getExit("east").getShortDescription());

		if(player.getCurrentRoom().getExit("west") != null)
			System.out.println("west: " + player.getCurrentRoom().getExit("west").getShortDescription());

		if(player.getCurrentRoom().getExit("south") != null)
			System.out.println("south: " + player.getCurrentRoom().getExit("south").getShortDescription());
		
		if(player.getCurrentRoom().name.equals("The Foyer"))
			System.out.println("To leave from the foyer, enter command: leave house");

		System.out.println();
	}

	private static void printInteraction(Player player, int itemIndex) {

		System.out.println(player.getCurrentRoom().getItem(itemIndex).getDescription() + "\n");

		System.out.println("Your options still remain \n");
		printOptions(player);

	}

	private static String[] collectInput() {

		input = sc.nextLine().toLowerCase().split(" ");
		System.out.println();

		return input;

	}

	private static void parse(String[] command, Player player) {

		if (command[0].equals("go") && directions.contains(command[1])) {
			if(player.getCurrentRoom().getExit(command[1]) != null) {
				player.currentRoom = player.getCurrentRoom().getExit(command[1]);
				printRoom(player);
			}
			else {
				System.out.println("There is no room in that direction. \n");
			}
			return;
		}

		if(player.getCurrentRoom().getItems() != null) {
			for (int i =0; i < player.getCurrentRoom().getItems().length; i++) {
				if (player.getCurrentRoom().getItem(i).getDirections().contains(command[0]) && player.getCurrentRoom().getItem(i).getDirections().contains(command[1])) {
					printInteraction(player, i);
					return;
				}

			}
		}
		
		if (command[0].equals("leave") && command[1].equals("house") && player.getCurrentRoom().getName().equals("The Foyer")) {
			System.out.println("Thank you for visiting today");
			System.exit(0);
		}
		
		else if (command[0].equals("leave") && command[1].equals("house")  && !player.getCurrentRoom().getName().equals("The Foyer")){
			System.out.println("You can't leave the house from here. You need to back to the foyer. \n");
			System.out.println("Your options still remain \n");
			printOptions(player);
			return;
		}
		
		else {
			System.out.println("You stand there, completely zoned out, thinking about random jargon. \n");
			System.out.println("Your options still remain \n");
			printOptions(player);
		}



	}


}
