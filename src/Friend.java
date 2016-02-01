/*
 * Class for Friend command
 * Setter/getter data for making players friends
 */
public class Friend {
	private int id1;
	private int id2;

	public Friend(int id1, int id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

}
