// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443

public class PlayerRecord {
	
	// Creating instance variables
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
	
	public PlayerRecord(String name, String position, String team, int GamesPlayed, int goals, int assists, int PIM, int ShotsonGoal, int GameWinningGoals){
		//Setting
		this.name = name;
		this.team = team;
		this.position = position;
		this.GP = GamesPlayed;
		this.G = goals;
		this.A = assists;
		this.SOG = ShotsonGoal;
		this.GWG = GameWinningGoals;
		this.PIM = PIM;
	}
	
	//getters
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
	
	// String to string method to print out the values of the record
	public String toString() {return name + " " + position + " " + team + " " + GP + " " + G + " " + A + " " + PIM + " " + SOG + " " + GWG;}
	
}
