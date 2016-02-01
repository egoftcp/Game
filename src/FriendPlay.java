/*
 * Class for FriendPlay command
 * Getters/setters for showing what 
 * friends play a certain game
 */
public class FriendPlay {
	private int playerId;
	private int gameId;

	public FriendPlay(int playerId, int gameId) {
		super();
		this.playerId = playerId;
		this.gameId = gameId;
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

}
