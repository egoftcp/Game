/*
 * Class for Play command
 * Contains getters and setters for 
 * setting a player as having played 
 * a certain game
 */
public class Play {
	
	private int playerId;
	private int gameId;
	private String name;

	public Play(int playerId, int gameId, String name) {
		super();
		this.playerId = playerId;
		this.gameId = gameId;
		this.name = name;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
