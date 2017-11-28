// // Assignment 2 - Binary Tree, October 30th - Stephen Terrio, B00755443
public class Pair {
	
	private char value;
	private double prob;
	
	public Pair(String val, double prob){
		
		//Getting the letter from a string of one letter (Converts from String to Char)
		value = val.charAt(0);
		this.prob = prob;
	}
	
	//getters
	public char getValue(){return value;}
	public double getProb(){return prob;}
	
	//setters
	public void setValue(String val){this.value = val.charAt(0);}
	public void setProb(double prob){this.prob = prob;}
	
}
