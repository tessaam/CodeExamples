
public class Dart {
	private double x;
	private double y;
	public Dart (){
	//sets random coordinates, within 2 on a 2x2 grid, for the darts to land in
		 x = 2 * Math.random();
		 y = 2 * Math.random();
	}
	public boolean isWithin(){
	//returns true if the point lies within the radius of a circle
		return (this.distance() < 1);
	}
	public double distance() {
	//computes the distance of a dart from the center of a circle
		double distance = Math.sqrt(Math.pow((this.x - 1),2) + Math.pow((this.y - 1), 2));
		return distance;
	}
	
}
