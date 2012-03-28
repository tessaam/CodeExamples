
public class Dart {
    double x;
	double y;
	
	double[] AP;
	double[] BP;
	double[] CP;
	
	public Dart (){
		//sets darts to shoot within the bounds of all the shapes
		x = AreaEstimator.leftBoundDart + (Math.random() * (AreaEstimator.rightBoundDart - AreaEstimator.leftBoundDart));
		y = AreaEstimator.bottomBoundDart + (Math.random() * (AreaEstimator.topBoundDart - AreaEstimator.bottomBoundDart));
	}
	
	//returns boolean value if dart lands in a circle
	
	public boolean isWithinCircle(Circle c){
		return (this.distanceFromCenter(c) < c.radius);
	}

	//computes the distance from a point to a circle's center
	
	public double distanceFromCenter(Circle c) {
		double distance = Math.sqrt(Math.pow((this.x - c.x),2) + Math.pow((this.y - c.y), 2));
		return distance;
	}
	
	//returns true or false if a point is in a triangle.
	
	public boolean isWithinTriangle(Triangle t){
		//makes vectors out of the line segment AB AC and AP where p is the coordinates of the dart.
		
		double [] vectorAC = {t.x3 - t.x, t.y3 - t.y};
		double [] vectorAB = {t.x2 - t.x, t.y2 - t.y};
		double [] vectorAP = {this.x - t.x, this.y - t.y};
		
		//finds the dot products of each of the vectors.
		
		double dotOfAC = dotProduct(vectorAC, vectorAC);
		double dotOfAcAb = dotProduct(vectorAC, vectorAB);
		double dotOfAcAp = dotProduct(vectorAC, vectorAP);
		double dotOfAB = dotProduct(vectorAB, vectorAB);
		double dotOfAbAp = dotProduct(vectorAB, vectorAP);
		
		//computes the vectors that follow the line segments AB and AC, if these values are between (0,1] return true.
		
		double invertDotProducts = 1 / (dotOfAC * dotOfAB - dotOfAcAb * dotOfAcAb);
		double u = (dotOfAB * dotOfAcAp - dotOfAcAb * dotOfAbAp) * invertDotProducts;
		double v = (dotOfAC * dotOfAbAp - dotOfAcAb * dotOfAcAp) * invertDotProducts;
		
		return ((u > 0) && (v > 0) && (u + v < 1));	
	}
	
	//computes the dot product of two vectors.
	
	public static double dotProduct (double [] n, double[] p){
		return((n[0] * p[0]) + (n[1]* p[1]));
	}
}
