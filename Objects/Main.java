import java.util.*;

public class Main {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you testing rectangle or circle?");
		
		String input = sc.next();
		if(input.toLowerCase().contains("rectangle")){
			
		//Handling the rectangle circumstance
		System.out.println("Enter in x & y postion then height and width values for each rectangle:");
		
		//Values foe the constructor
		double xp = sc.nextDouble();
		double yp = sc.nextDouble();
		double ht = sc.nextDouble();
		double wdt = sc.nextDouble();
		
		double xp2 = sc.nextDouble();
		double yp2 = sc.nextDouble();
		double ht2 = sc.nextDouble();
		double wdt2 = sc.nextDouble();
		
		//Creating the two objects.
		rectangle rect = new rectangle(xp,yp,ht,wdt);
		rectangle rect2 = new rectangle(xp2,yp2,ht2,wdt2);
		
		if(rect.contains(rect2)){
			System.out.println("rectangle 1 contains rectangle 2.");
		} else{
			System.out.println("rectangle 1 does not contain rectangle 2.");
		}
		
		if(rect.touches(rect2)){
			System.out.println("rectangle 1 touches rectangle 2.");
		}else{
			System.out.println("rectangle 1 does not touch rectangle 2.");
			}
		}
		
		
		// Handling the circle case
	else if(input.toLowerCase().contains("circle")){
		System.out.println("Enter in x & y positon as well as radiuses for each circle:");
			
		double xcen = sc.nextDouble();
		double ycen = sc.nextDouble();
		double radi = sc.nextDouble();
		
		double xcen2 = sc.nextDouble();
		double ycen2 = sc.nextDouble();
		double radi2 = sc.nextDouble();
		
		Circle circ = new Circle(xcen,ycen,radi);
		Circle circ2 = new Circle(xcen2,ycen2,radi2);
		
		if(circ.contains(circ2)){
			System.out.println("circle 1 contains circle 2.");
		} else{
			System.out.println("circle 1 does not contain circle 2.");
		}
		
		
		if(circ.touches(circ2)){
			System.out.println("circle 1 touches circle 2.");
		}else{
			System.out.println("circle 1 does not touch circle 2.");
			}
		}
	}
}