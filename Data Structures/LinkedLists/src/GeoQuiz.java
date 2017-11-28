import java.util.Scanner;
import java.io.*;

public class GeoQuiz {
	public static void main(String arg[])throws IOException{
		
		List <Country_cap> pairs = new List <Country_cap>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location of your text file: ");
		String filename = sc.nextLine();
		
		File text = new File(filename);
		Scanner file = new Scanner(text);
		
		while (file.hasNextLine()){
			
			String tempCou = file.nextLine();
			String tempCap = file.nextLine();

			Country_cap pair = new Country_cap(tempCou, tempCap);
			pairs.add(pair);
		}
		boolean playing;
		
		System.out.println("Welcome to the Country-Capital Quiz");
		System.out.println("Play? ");
		
		if (sc.next().toLowerCase().equals("yes")){playing = true;}
		else{playing = false; System.out.println("Game Over");}
	
		while (playing){
			
			Country_cap temp = pairs.first();
			
			// Getting a random pair
			int s = 0 + (int)(Math.random() * ((pairs.size() - 0) + 1));
			for(int i = 0; i <= s; i++){
				temp = pairs.next();
			}
			
			System.out.println("What is the capitol of " + temp.getCountry());
			String answer = temp.getCapitol();	
			if (sc.next().toLowerCase().equals(answer.toLowerCase())) { System.out.print("Correct! Play? ");}
			else {System.out.print("Incorrect. The correct answer is " + answer  + "."+ " Play?");}
			
			if(sc.next().toLowerCase().equals("no")){ System.out.println("Game Over."); break;}
		}		
	}
}
