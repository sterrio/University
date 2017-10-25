// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class NHLStats {

	private LinkedList <PlayerRecord> playerList;
	
	public NHLStats(LinkedList <PlayerRecord> temp){
		
		playerList = temp;
	}
	
	public LinkedList<PlayerRecord> highestPoints(){
		
		LinkedList<PlayerRecord> highestPlayers = new LinkedList <PlayerRecord>();
		int highest = 0;
		
		for (int i = 0; i < playerList.size(); i ++){
			if (playerList.getAt(i) == null);
			
			else if (highest < playerList.getAt(i).getG() + playerList.getAt(i).getA()){
			
				highestPlayers.clear();
				highestPlayers.add(playerList.getAt(i));
				highest = playerList.getAt(i).getG() + playerList.getAt(i).getA();
			}
			
			else if (highest == playerList.getAt(i).getG() + playerList.getAt(i).getA()){
				highestPlayers.add(playerList.getAt(i));
			}
		}
		return highestPlayers;
	}

	public LinkedList<PlayerRecord>  mostAggressive(){
		
		LinkedList<PlayerRecord> agressPlayers = new LinkedList <PlayerRecord>();
		int highest = 0;
		
		for (int i = 0; i < playerList.size(); i ++){
			if (playerList.getAt(i) == null);
			
			else if (highest < playerList.getAt(i).getPIM()){
			
				agressPlayers.clear();
				agressPlayers.add(playerList.getAt(i));
				highest = playerList.getAt(i).getPIM();
			}
			
			else if (highest == playerList.getAt(i).getPIM()){
				agressPlayers.add(playerList.getAt(i));
			}
		}
		return agressPlayers;
	}

	public LinkedList<PlayerRecord> MVP(){
		
		LinkedList<PlayerRecord> mvpPlayers = new LinkedList <PlayerRecord>();
		int highest = 0;
		
		for (int i = 0; i < playerList.size(); i ++){
			if (playerList.getAt(i) == null);
			
			else if (highest < playerList.getAt(i).getGWG()){
			
				mvpPlayers.clear();
				mvpPlayers.add(playerList.getAt(i));
				highest = playerList.getAt(i).getGWG();
			}
			
			else if (highest == playerList.getAt(i).getGWG()){
				mvpPlayers.add(playerList.getAt(i));
			}
		}
		return mvpPlayers;
	}

	public LinkedList<PlayerRecord> mostPromising(){
		LinkedList<PlayerRecord> potentialPlayers = new LinkedList <PlayerRecord>();
		int highest = 0;
		
		for (int i = 0; i < playerList.size(); i ++){
			if (playerList.getAt(i) == null);
			
			else if (highest < playerList.getAt(i).getSOG()){
			
				potentialPlayers.clear();
				potentialPlayers.add(playerList.getAt(i));
				highest = playerList.getAt(i).getSOG();
			}
			
			else if (highest == playerList.getAt(i).getSOG()){
				potentialPlayers.add(playerList.getAt(i));
			}
		}
		return potentialPlayers;
	}

	public void mostPenalty(PrintWriter writer)throws IOException{
		
		HashMap<String, Integer> path = new HashMap<String, Integer>();
		LinkedList<String> teams = new LinkedList <String>();
		
		for (int i = 0; i < playerList.size(); i ++){
			if (path.containsKey(playerList.getAt(i).getTeam())){
				
			path.put(playerList.getAt(i).getTeam(), path.get(playerList.getAt(i).getTeam()) + playerList.getAt(i).getPIM());
			}
			else {
				path.put(playerList.getAt(i).getTeam(), playerList.getAt(i).getPIM());
			}
		}
		int most = 0;
		
		for(Map.Entry p: path.entrySet()){
			
			if (most < (int) p.getValue()){
				
				teams.clear();
				most = (int) p.getValue();
				teams.add((String) p.getKey());
			}
			
			else if (most == (int) p.getValue()){
				teams.add((String) p.getKey());
			}
			
		}
		
		for (int i = 0; i < teams.size(); i++){
			writer.println(teams.getAt(i) + "\t" + most);
			System.out.println(teams.getAt(i) + "\t" + most);
		}
	}

	public void mostGameWinningGoals(PrintWriter writer)throws IOException{
		
		HashMap<String, Integer> path = new HashMap<String, Integer>();
		LinkedList<String> teams = new LinkedList <String>();
		
		for (int i = 0; i < playerList.size(); i ++){
			if (path.containsKey(playerList.getAt(i).getTeam())){
				
			path.put(playerList.getAt(i).getTeam(), path.get(playerList.getAt(i).getTeam()) + playerList.getAt(i).getGWG());
			}
			else {
				path.put(playerList.getAt(i).getTeam(), playerList.getAt(i).getGWG());
			}
		}
		int most = 0;
		
		for(Map.Entry p: path.entrySet()){
			
			if (most < (int) p.getValue()){
				
				teams.clear();
				most = (int) p.getValue();
				teams.add((String) p.getKey());
			}
			
			else if (most == (int) p.getValue()){
				teams.add((String) p.getKey());
			}
			
		}
		
		for (int i = 0; i < teams.size(); i++){
			writer.println(teams.getAt(i) + "\t" + most);
			System.out.println(teams.getAt(i) + "\t" + most);
		}
	}

}
