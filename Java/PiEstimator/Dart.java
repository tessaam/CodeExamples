/* Dart class for approximating Pi. Randomly generates x, y coordinates and 
 * has a method for returning if the dart is within the circle.
 */
 
public class Dart {
	private double x;
	private double y;
	
	//sets random coordinates, within 2 on a 2x2 grid, for the darts to land in
	public Dart (){
		 x = 2 * Math.random();
		 y = 2 * Math.random();
	}
	
	//returns true if the point lies within the radius of a circle
	public boolean isWithin(){
		return (this.distance() < 1);
	}
	
	//computes the distance of a dart from the center of a circle
	public double distance() {
		double distance = Math.sqrt(Math.pow((this.x - 1),2) + Math.pow((this.y - 1), 2));
		return distance;
	}	
}
