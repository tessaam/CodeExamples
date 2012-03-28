/* Java program that estimates the area of an arbitrary number of 
 * circles and triangles by generating random points and returning 
 * how many of those pts are within the bounds of that shape
 */
 
import java.util.Arrays;

public class AreaEstimator {
	
	public static double leftBoundDart;
	public static double rightBoundDart;
	public static double bottomBoundDart;
	public static double topBoundDart;
	
	public static void main (String[] args){
		double numberOfDartThrows = Long.parseLong(args[0]);
		double counter = 0;
		
		int circCounter = 0;
		int triCounter = 0;
		int q = 0;
		int k = 0;

		//counts the number of circle and triangle arguments
		for (int i = 0; i < args.length; i++){
			if (args[i].equals("circle")){
				circCounter++;
			}
			if (args[i].equals("triangle")){
				triCounter++;
			}
		}
		//stores the triangles in an array
		Triangle[] triArray = new Triangle[triCounter]; 
		Circle[] circArray = new Circle[circCounter]; 
		Object[] shapesArray = new Object[triCounter + circCounter];
			
		// adds points to circles and triangles accordingly
		for (int i = 1; i < args.length; i++){
			if (args[i].equals("circle")){
				circArray[q] = new Circle (Double.parseDouble(args[i+1]), Double.parseDouble(args[i+2]), Double.parseDouble(args[i+3]));
				
				q++;	
			}
		
			if (args[i].equals("triangle")){
				triArray[k] = new Triangle (Double.parseDouble(args[i+1]), Double.parseDouble(args[i+2]),Double.parseDouble(args[i+3]), Double.parseDouble(args[i+4]), Double.parseDouble(args[i+5]), Double.parseDouble(args[i+6]));
				k++;
			}
		}
		// creates an array of shapes
		for (int i = 0; i < circArray.length; i ++){
			shapesArray[i] = circArray[i];
		}
		for (int i = circArray.length; i < shapesArray.length; i++){
			shapesArray[i] = triArray[i - circArray.length];
		}
	
		Circle getCircleType = new Circle (0.0,0.0,1.0);
		
		double [] leftBounds = new double[circCounter + triCounter];
		double [] rightBounds = new double[circCounter + triCounter];
		double [] topBounds = new double[circCounter + triCounter];
		double [] bottomBounds = new double[circCounter + triCounter];
		
		//holds the bounds of all the shapes
		
		for (int i = 0; i < shapesArray.length; i++){
			if (shapesArray[i].getClass() == getCircleType.getClass()){
				topBounds[i] = ((Circle) shapesArray[i]).getTopBound();
			}
			if (shapesArray[i].getClass() != getCircleType.getClass()){
				topBounds[i] = ((Triangle) shapesArray[i]).getTopBound();
			}
		}
		for (int i = 0; i < shapesArray.length; i++){
			if (shapesArray[i].getClass() == getCircleType.getClass()){
				bottomBounds[i] = ((Circle) shapesArray[i]).getBottomBound();
			}
			if (shapesArray[i].getClass() != getCircleType.getClass()){
				bottomBounds[i] = ((Triangle) shapesArray[i]).getBottomBound();
			}
		}
		for (int i = 0; i < shapesArray.length; i++){
			if (shapesArray[i].getClass() == getCircleType.getClass()){
				rightBounds[i] = ((Circle) shapesArray[i]).getRightBound();
			}
			if (shapesArray[i].getClass() != getCircleType.getClass()){
				rightBounds[i] = ((Triangle) shapesArray[i]).getRightBound();
			}
		}
		for (int i = 0; i < shapesArray.length; i++){
			if (shapesArray[i].getClass() == getCircleType.getClass()){
				leftBounds[i] = ((Circle) shapesArray[i]).getLeftBound();
			}
			if (shapesArray[i].getClass() != getCircleType.getClass()){
				leftBounds[i] = ((Triangle) shapesArray[i]).getLeftBound();
			}
		}
				
		//sorts all of the bounds array
		
		Arrays.sort(leftBounds);
		Arrays.sort(rightBounds);
		Arrays.sort(topBounds);
		Arrays.sort(bottomBounds);
	
		//sets bounds to the extremes of each shape
		
	     leftBoundDart = leftBounds[0];
		 rightBoundDart = rightBounds[rightBounds.length - 1];
    	 bottomBoundDart = bottomBounds[0];
	     topBoundDart = topBounds[topBounds.length - 1];
		 double BoundingRectArea = Math.abs((rightBoundDart - leftBoundDart) * (topBoundDart - bottomBoundDart));
		
		//iterates through the triangle and circle arrays and finds when a dart lies within all the shapes; then when the dart is found to be in all the 
		 //shapes the counter is increased.
		 
		 for (int i = 0; i < numberOfDartThrows; i++){
			Dart n = new Dart();	
			int allCircCount = 0;
			int allTriCount = 0;
			boolean inAllCirc = false;
			boolean inAllTri = false;
			
			for (int j = 0; j < circArray.length; j++){
				if(n.isWithinCircle(circArray[j])){
					allCircCount++;
				}
			}
			
			for (int p = 0; p < triArray.length; p++){
				if(n.isWithinTriangle(triArray[p])) {
					allTriCount++;
				}
			}
			
			if(circArray.length > 0 && triArray.length > 0){
				if (allCircCount == circArray.length) inAllCirc = true;
				if (allTriCount == triArray.length) inAllTri = true;
				if (inAllCirc && inAllTri){ 
					counter++;
				}
			}
			
			if (circArray.length == 0 && triArray.length > 0){
				if (allTriCount == triArray.length) inAllTri = true;
				if (inAllTri) counter++;
			}
			
			if (triArray.length == 0 && circArray.length > 0){
				if (allCircCount == circArray.length) inAllCirc = true;
				if (inAllCirc) counter++;
			}
			
		}
		 
		//prints out the ratio of darts that landed in the area / total darts multiplied by the bounding rectangle area to give the final result.
		 
		System.out.println((counter/numberOfDartThrows) * BoundingRectArea);	
	}
}



