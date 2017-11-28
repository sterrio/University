//Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

public class Point<P> {
	
	//creating generic variables to be used in an object parameters
	private P xValue;
	private P yValue;
	
	//Making constructor for new object Point.
	public Point(P x, P y){xValue = x; yValue = y;}
	
	// Getter methods for both X and Y coordinates
	public P getX(){return xValue;}
	public P getY(){return yValue;}
	
	// Setter methods for both X and Y coordinates
	public void setX(P x){xValue = x;}
	public void setY(P y){yValue = y;}
	
	// Printing out both X and Y coordinates.
	public String toString(){return "XPOS: "+xValue + "\t YPOS: "+ yValue;}
	
	//Imported main method from PDF to test code.
	public static void main(String [] args){
	
		Point<Integer> point1 = new Point<Integer>(10,20);
		Point<Double> point2 = new Point<Double>(14.5, 15.6);
		Point<String> point3 = new Point<String>("topleftx", "toplefty");
		
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);
		
	}
}