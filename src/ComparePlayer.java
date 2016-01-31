
public class ComparePlayer {

	private int player1Id;
	private int player2Id;
	private int gameId;

	public ComparePlayer(int player1Id, int player2Id, int gameId) {
		super();
		this.player1Id = player1Id;
		this.player2Id = player2Id;
		this.gameId = gameId;
	}

	public int getPlayer1Id() {
		return player1Id;
	}

	public void setPlayer1Id(int player1Id) {
		this.player1Id = player1Id;
	}

	public int getPlayer2Id() {
		return player2Id;
	}

	public void setPlayer2Id(int player2Id) {
		this.player2Id = player2Id;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
