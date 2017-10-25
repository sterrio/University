// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class NHLListDemo {
	public static void main(String [] arg)throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location of your text file: ");
		String filename = sc.nextLine();
		filename = "/Users/jarretterrio/Desktop/nhlstats.txt";
		
		File text = new File(filename);
		Scanner file = new Scanner(text);
		StringTokenizer token;
		
		// Creating a Linked List to hold all the Players info
		LinkedList <PlayerRecord> playlist = new LinkedList <PlayerRecord>();
		
		while (file.hasNext()){
			
			String line = file.nextLine();
			token = new StringTokenizer(line, "\t");
			
			// All string values to take in
			String Name = token.nextToken();
			String Position = token.nextToken();
			String Team = token.nextToken();
			
			// All integer values to take in converted to integers from string
			String GPlayed = token.nextToken();
			int GamesPlayed = Integer.parseInt(GPlayed);
			
			String Goal = token.nextToken();
			int Goals = Integer.parseInt(Goal);
			
			String Assist = token.nextToken();
			int Assists = Integer.parseInt(Assist);
			
			String PIM = token.nextToken();
			int PenaltyinMinutes = Integer.parseInt(PIM);
			
			String SOG = token.nextToken();
			int ShotsonGoal = Integer.parseInt(SOG);
			
			String GameWinningGoals = token.nextToken();
			int GWG = Integer.parseInt(GameWinningGoals);
			
			PlayerRecord PlayerInfo = new PlayerRecord(Name, Position, Team, GamesPlayed, Goals, Assists, PenaltyinMinutes, ShotsonGoal,GWG);
			playlist.add(PlayerInfo);
		}
		file.close();
		
		NHLStats nhl = new NHLStats(playlist);
		
		for (int i = 0; i < nhl.highestPoints().size(); i ++){
			System.out.println(nhl.highestPoints().getAt(i));
		}
		
		for (int i = 0; i < nhl.mostAggressive().size(); i ++){
			System.out.println(nhl.mostAggressive().getAt(i));
		}
		
		for (int i = 0; i < nhl.MVP().size(); i ++){
			System.out.println(nhl.MVP().getAt(i));
		}
		
		for (int i = 0; i < nhl.mostPromising().size(); i ++){
			System.out.println(nhl.mostPromising().getAt(i));
		}

	}
}
