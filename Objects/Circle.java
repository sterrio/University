//Objects - Circle, September 17th 2017, Stephen Terrio B00755443
import java.util.Scanner;

public class Circle {
	
	private double x,y,r;
	
	public Circle(double cenX,double cenY,double radius){
		this.x = cenX;
		this.y = cenY;
		this.r = radius;
	}

	public double getcenX(){return x;}
	public double getcenY(){return y;}
	public double getradius(){return r;}
	
	public boolean touches(Circle circ){
		double distance = (Math.sqrt(Math.pow( (this.x - circ.getcenX()),2) + Math.pow(this.y - circ.getcenY(),2)));
		
		if (this.r == circ.getradius() && distance == 0 
		|| Math.sqrt(Math.pow( (this.x - circ.getcenX()),2) + Math.pow(this.y - circ.getcenY(),2)) == this.r + circ.getradius()) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean contains(Circle circ){
		double distance = (Math.sqrt(Math.pow( (this.x - circ.getcenX()),2) + Math.pow(this.y - circ.getcenY(),2)));
		
		if(circ.getradius() + distance <= this.r){
			return true;
		}
		else{
			return false;
		}	
	}
}
