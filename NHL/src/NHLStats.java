// Assignment 2 - Linked Lists, October 24th - Stephen Terrio, B00755443

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
}
