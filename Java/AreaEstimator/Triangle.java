

public class Triangle {
	 double x;
	 double y;
	 double x2;
	 double y2;
	 double x3;
	 double y3;
	 
	 double [] boundsOf = null;
	
	//creates a new triangle with 6 arg that make up the three points
	
	public Triangle (double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY){
		x = firstX;
		y = firstY;
		x2 = secondX;
		y2 = secondY;
		x3 = thirdX;
		y3 = thirdY;
		
		double [] boundsOf1 = {x, y, x2, y2, x3, y3};
		this.boundsOf = boundsOf1;
		
	}
	
	//returns the left, right, top, and bottom bounds of an array by sorting 
	
	public double getLeftBound (){
		double [] horizontalBounds = {this.boundsOf[0], this.boundsOf[2], this.boundsOf[4]};
		double min = horizontalBounds[0];
		for (int i = 0; i < horizontalBounds.length; i++){
			if ( horizontalBounds[i] < min ) min = horizontalBounds[i];
		}
		return min;
	}
	
	public double getRightBound (){
		double [] horizontalBounds = {this.boundsOf[0], this.boundsOf[2], this.boundsOf[4]};
		double max = horizontalBounds[0];
		for (int i = 0; i < horizontalBounds.length; i++){
			if ( horizontalBounds[i] > max ) max = horizontalBounds[i];
		}
		return max;
	}
	
	public double getBottomBound (){
		double [] verticalBounds = {this.boundsOf[1], this.boundsOf[3], this.boundsOf[5]};
		double min = verticalBounds[0];
		for (int i = 0; i < verticalBounds.length; i++){
			if ( verticalBounds[i] < min ) min = verticalBounds[i];
		}
		return min;
	}
	
	public double getTopBound (){
		double [] verticalBounds = {this.boundsOf[1], this.boundsOf[3], this.boundsOf[5]};
		double max = verticalBounds[0];
		for (int i = 0; i < verticalBounds.length; i++){
			if ( verticalBounds[i] > max ) max = verticalBounds[i];
		}
		return max;
	}
}
