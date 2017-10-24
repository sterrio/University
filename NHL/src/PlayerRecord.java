// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443

public class PlayerRecord {
	
	private String position;
	private String name;
	private String team;
	
	private int GP; // Games played
	
	private int G; // Goals
	private int A; // Assists
	
	private int SOG; // Shots on goal 
	private int GWG; // Game winning goals
	private int PIM; // Penalties in minutes
	private int P = G + A; // Points
	
	public PlayerRecord(String name, String team, String position, int GamesPlayed, int goals, int assists, int ShotsonGoal, int GameWinningGoals, int PIM){
		//Setters
		name = this.name;
		team = this.team;
		position = this.position;
		GamesPlayed = this.GP;
		goals = this.G;
		assists = this.A;
		ShotsonGoal = this.SOG;
		GameWinningGoals = this.GWG;
		PIM = this.PIM;
		int Points = this.P;
	}
	public String getName(){return name;}
	public String getTeam(){return team;}
	public String getPos(){return position;}
	
	public int getGP(){return GP;}
	public int getG(){return G;}
	public int getA(){return A;}
	
	public int getSOG(){return SOG;}
	public int getGWG(){return GWG;}
	public int getPIM(){return PIM;}
	public int getPoints(){return P;}
}
