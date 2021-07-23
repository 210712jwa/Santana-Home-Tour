package fixtures;

public class Interactables {
	
	private String name;
	private String directions;
	private String description;
	
	public Interactables(String name, String directions, String description){
		this.name = name;
		this.directions = directions;
		this.description = description;
	}



	public String getName() {
		return name;
	}

	public String getDirections() {
		return directions;
	}

	
	public String getDescription() {
		return description;
	}	
	
}
