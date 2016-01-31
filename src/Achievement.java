
public class Achievement {
	private int gId;
	private int aId;
	private String aName;
	private int points;

	public Achievement(int gId, int aId, String aName, int points) {
		super();
		this.gId = gId;
		this.aId = aId;
		this.aName = aName;
		this.points = points;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
