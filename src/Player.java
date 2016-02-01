/*
 * Class for Achieve command
 * Contains getters and setters for 
 * adding a new player to database
 */
public class Player {
	
	private int id ;
	private String name ;
	
	
	
	public Player(int id, String name) {
		super();
		setId(id);
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id>=0)
		   this.id = id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
