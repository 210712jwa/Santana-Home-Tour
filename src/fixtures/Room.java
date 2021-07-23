package fixtures;

public class Room extends Fixture{
	
	
	private Room[] exits;
	private Interactables[] items;
	
	
	public Room(String name, String shortDescription, String longDescription, Interactables[] items) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4];
		this.items = items;
	}
	
	public void setExits(Room north, Room south, Room east, Room west) {
		exits[0] = north;
		exits[1] = south;
		exits[2] = east;
		exits[3] = west;
		
	}
		
	public Interactables[] getItems() {
		return items;
	}
	
	public Interactables getItem(int index) {
		return items[index];
	}

	public Room[] getExits() {
		return exits;
	}
		
	public Room getExit(String direction) {
		
		switch (direction) {
			case "north":
				return exits[0];
			
			case "east":
				return exits[1];
				
			case "west":
				return exits[2];
			
			case "south":
				return exits[3];
				
			default:
				return null;
			
		}
	}
	
	
	
}
