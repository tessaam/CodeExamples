
public class PiEstimator {
	public static void main (String [] args){
		long numberOfDartThrows = Long.parseLong(args[0]);
		double counter = 0.0;
		// makes a new dart and "shoots" it on a 2x2 square.
		// If the dart lands within a circle with radius 1 that is
		// inscribed the 2x2 square, the counter is increased by 1.
		for (int i = 0; i < numberOfDartThrows; i ++){
			 Dart n = new Dart();
			 if (n.isWithin()){
				 counter++;
			 }
		}
		//prints out the PiEstimation by dividing the counter by the total
		//number of darts shot and multiplying it by four.
		System.out.println(4*(counter/numberOfDartThrows));
	}
	
}

