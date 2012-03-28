

public class Circle {
	 double x;
	 double y;
	 double radius;
	 
	 double[] boundsOf = null;
	
	public Circle (double centerX, double centerY, double radiusCirc){
		x = centerX;
		y = centerY;
		radius = radiusCirc;
	    double boundsOf1[] = {(this.x - this.radius), (this.x + this.radius), (this.y + this.radius), (this.y - this.radius)};
	    this.boundsOf = boundsOf1;
	}
	
	//returns the left bound
	public double getLeftBound () {
		return boundsOf[0];
	}
	//returns the right bound
	public double getRightBound () {
		return boundsOf[1];
	}
	//returns the top bound
	public double getTopBound () {
		return boundsOf[2];
	}
	//returns the bottom bound
	public double getBottomBound () {
		return boundsOf[3];
	}
	
}
