/* Simple Java program that takes an angle and outputs all the times in the
 * day where the two hands make an angle within 2 degrees.
 */

public class ClockSolver {
	
	public static void main(String[] args) {
	
		short angle = Short.parseShort(args[0]);
		double timeSlice; 
		Clock simulation = new Clock();
		
		//Checks for a second commandline argument to set it as the
		//timeSlice
		if (args.length < 2) {
			timeSlice = 1; //default timeSlice if one is not specified
		} else {
			timeSlice = Double.parseDouble(args[1]);
		}
		
		//While the clock is not expired, calculate the currentAngle. If it
		//is within 2 degrees of the user inputted angle, print the current time.
		//if it is not, keep ticking the clock.
		
		while (!simulation.clockExpired()) {
			if (Math.abs(simulation.currentAngle() - angle) < 2) {
				System.out.println(Math.abs(simulation.currentAngle()) +  "  "
				+ simulation.printTime()); //prints angle and the current time
				simulation.tick(timeSlice);
			} else {
				simulation.tick(timeSlice);
			}	
		}	
	}
}

//Constructor for Clock objects.

class Clock {
	
	//Clock will be incremented in seconds and here is the variable that will hold those values
	double seconds = 0;
	
	//Returns the current hour based off the current amount of seconds.
	int hour() {
		return (int) this.seconds/3600;
	}
	
	//Returns the current second on the clock, not formatted for printing.
	double getSecond() {
		return this.seconds;
	}
	
	//Returns the current minute used in currentAngle and printTime
	int minute() {
		int remainder = (int) this.seconds % 3600,
		minutes = remainder / 60;
		return minutes;
	}
	
	//Returns the formatted second count for the printTime method
	int second() {
		int remainder = (int) this.seconds % 3600,
		roundedSecond = remainder % 60;
		return roundedSecond;
	}
	
	//Advances the clock at a given interval.
	void tick(double t) {
		this.seconds += t;
	}
	
	//Returns the angle between the hour and minute hand at the current time
	double currentAngle(){
		return Math.abs(.5 * ((60 * this.hour()) - (11 * this.minute())));
	}
	
	//Returns whether or not the clock has run through a 12-hour period
	boolean clockExpired() {
		// 43200 is the number of seconds in a 12 hr period
		return (this.seconds > 43200.0); 
	}
	
	//Prints the current time on the clock. Adds 0 in front of times less than 10
	String printTime() {
		return ((this.hour() == 0) ? "12" : this.hour()) + ":" + 
			((this.minute() < 10) ? "0"+ this.minute() : this.minute()) + ":" + 
			((this.second() < 10) ? "0" + this.second() : this.second());
	}
}