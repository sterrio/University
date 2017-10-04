// Rectangle object, Exercise 1, September 14th, 2017, Stephen Terrio B00755443.
import java.util.Scanner;

public class rectangle {
	// Initializing instance variables to represent object values.
	
	private double xplacement,yplacement,objWidth,objHeight;
	
	//making a constructor for rectangle and setting variables.
	public rectangle(double xpos, double ypos, double height, double width) {
		this.xplacement = xpos;
		this.yplacement = ypos;
		this.objHeight = height;
		this.objWidth = width;
	}
	
	// Making setter methods using instance variables.
	public void setXpos(double changeXpos){this.xplacement = changeXpos;}
	public void setYpos(double changeYpos){this.yplacement = changeYpos;}
	public void setHeight(double changeHeight){	this.objHeight = changeHeight;}
	public void setWidth(double changeHeight){this.objWidth = changeHeight;}
	
	//Making getter methods using instance variables.
	public double getXpos(){return xplacement;}
	public double getYpos(){return yplacement;}
	public double getHeight(){return objHeight;}
	public double getWidth(){return objWidth;}
	
	//Making contains method for rectangle using the four corners to determine if ones inside the other.
	public boolean contains(rectangle r2){
		if ((this.xplacement + this.objWidth) >= (r2.getXpos() + r2.getWidth()) && this.xplacement >= r2.getXpos() && this.yplacement >= r2.getYpos() 
		&& this.yplacement + this.objHeight >= r2.getYpos() + r2.getHeight()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Making touches method by comparing each corner and seeing if the values match the other.
	public boolean touches(rectangle r2){
		
		//top corner check
		if ((((r2.getXpos() == this.xplacement || r2.getXpos() == this.xplacement + this.objWidth) && r2.getYpos() == this.yplacement)
		||  ((r2.getXpos() == this.xplacement || r2.getXpos() == this.xplacement + this.objWidth) && r2.getYpos() == this.yplacement + this.objHeight)) ||
		
			//top right corner check
			(((r2.getXpos() + r2.getWidth() == this.xplacement || r2.getXpos() + r2.getWidth() == this.xplacement + this.objWidth) && r2.getYpos() == this.yplacement)
		||  ((r2.getXpos() + r2.getWidth() == this.xplacement || r2.getXpos() + r2.getWidth() == this.xplacement + this.objWidth) && r2.getYpos() == this.yplacement + this.objHeight)) ||
			
			//bottom corner check
			(((r2.getXpos() == this.xplacement || r2.getXpos() == this.xplacement + this.objWidth) && r2.getYpos() + r2.getHeight() == this.yplacement)
		||  ((r2.getXpos() == this.xplacement || r2.getXpos() == this.xplacement + this.objWidth) && r2.getYpos() + r2.getHeight() == this.yplacement + this.objHeight)) ||
			
			//bottom right corner check
			(((r2.getXpos() + r2.getWidth() == this.xplacement || r2.getXpos() + r2.getWidth() == this.xplacement + this.objWidth) && r2.getYpos() + r2.getHeight() == this.yplacement)
		||  ((r2.getXpos() + r2.getWidth() == this.xplacement || r2.getXpos() + r2.getWidth() == this.xplacement + this.objWidth) && r2.getYpos() + r2.getHeight() == this.yplacement + this.objHeight)))
			
		{
			
			return true;
		}
		else{
			return false;
		}
	}
}