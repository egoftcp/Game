/*
 * Class for Game command
 * Contains getters and setters for 
 * adding new game to database
 */
public class Game {
	
	private int id ;
	private String name ;
	
	
	
	public Game(int id, String name) {
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
