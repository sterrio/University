import java.util.Scanner;

public class exercise3 {
	
	public static rectangle getRectangle(double points[][]){
		
		//setting all values to first point in the array
		double maxX = points[0][0];
		double maxY = points[0][1];
		double minX = points[0][0];
		double minY = points[0][1];
		
		for(int i=0; i < points.length; i++){
			
		double X = points[i][0];//taking each x from the array
		double Y = points[i][1];//taking each y from the array
		
		//checking if current array value is the biggest/smallest
		if (X < minX){minX = X;}
		if (Y < minY){minY = Y;}
		if (X > maxX){maxX = X;}
		if (Y > maxY){maxY = Y;}
		}
		double Width = maxX - minX;
		double Height = maxY - minY;
		
		return new rectangle(minX,minY,Height,Width);
	}
	
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		double[][] points = new double[5][2];
		
		System.out.print("Enter " + points.length + " points: ");
		
		for (int i = 0; i < points.length; i++) {
		points[i][0] = input.nextDouble();
		points[i][1] = input.nextDouble();}
		
		rectangle boundingRectangle = getRectangle(points);
		double centerx = boundingRectangle.getWidth()/2 + boundingRectangle.getXpos();
		double centery = boundingRectangle.getHeight()/2 + boundingRectangle.getYpos();	
		
		System.out.println("The center of the rectangle is ("+ centerx + ","+ centery + ")");
		System.out.println("The width of the rectangle is "+ boundingRectangle.getWidth());
		System.out.println("The height of the rectangle is "+ boundingRectangle.getHeight());
	}
}
