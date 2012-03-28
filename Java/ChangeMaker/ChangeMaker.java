/* An example of dynamic programming as a generalized ChangeMaker. Takes in arguments as the 
 * the amount of change to make and the number of coin denominations
 * and returns the fewest number of coins to make the provided amount 
 * of change.
 */
 
public class ChangeMaker {

	public static void main(String[] args) {
	
		// creates all the variables; 
		// each cent is the list of cents from 0 through the argument
		// numberOfDenominations is the list of all the coins in the problem
		// tupleOfDenominations is a tuple with all values set to zero. It's 
		// length is equal to number of different denominations.
		// nullArray is an array of length zero, I was previously using null values
		// however that was yielding some weird values so I switched to an int[] of length 0
		// table creates the dimensions of the Tuple table.
		// String coinsString represents a string of all the coins
		
		if (Integer.parseInt(args[0]) < 0){
			System.out.println("improper amount: " + args[0]);
		}
		
		if (args.length == 1){
			System.out.println("insufficient data");
		}
		
		int [] eachCent = new int [Integer.parseInt(args[0]) + 1];
		int [] numberOfDenominations = new int [args.length - 1];
		int [] tupleOfDenominations = new int [numberOfDenominations.length];
		int [] nullArray = new int [0];
		Tuple [][] table = new Tuple [numberOfDenominations.length][eachCent.length];
		
		String coinsString = "";
		
		//sets the values for eachCent
		for (int i = 0; i < eachCent.length; i++){
			eachCent[i] = i;
		}
		
		//sets the values for the numberOfDenominations
		for (int i = 0; i < numberOfDenominations.length; i++){
			numberOfDenominations[i] = Integer.parseInt(args[i + 1]);
		}
		
		// carries out a series of tests to check for improper change amounts and denomination amounts
		
		for (int i = 0; i < numberOfDenominations.length; i ++){
			if (numberOfDenominations[i] <= 0){
				System.out.println("improper denomination: " + numberOfDenominations[i]);
			}
		}
		
		//checks for duplicate denominations
		int printValid = 0;
		
		for (int i = 0; i < numberOfDenominations.length; i ++){
			int counter = 0;
			for (int j = 0; j < numberOfDenominations.length; j ++){
				if (numberOfDenominations[i] == (numberOfDenominations[j])) counter++;
				if (counter > 1) printValid++;	
			}
			if (printValid > 1) System.out.println("duplicate denominations");	
		}
			
        for (int i = 1; i < eachCent.length; i++){
    		
        	//if the cent value is lower that than first coin value, a nullArray is set automatically to a null Array
        	
            if (eachCent[i] < numberOfDenominations[0]) {
                table[0][i] = new Tuple(nullArray);
            }
            
            //otherwise we add a coin to the new tuple and compute the difference of the cent value and the denomination.
            
            else {
            	//sets the first value of the table to a tupleOfDenominations of zero
            	
             	int[] zeroTupleArray = new int [numberOfDenominations.length];
        		for (int p = 0; p < numberOfDenominations.length; p++){
            		zeroTupleArray[p] = 0;
            	}
        		table [0][0] = new Tuple (zeroTupleArray);

        		// and we make a new tuple that is equal to zero. For some reason table[0][0] would increment each time table[0][i] did 
        		//so i had to reset each separately to ensure a valid result.
        		
            	Tuple t = new Tuple (tupleOfDenominations);
            	for (int j = 0; j < numberOfDenominations.length; j++){
            		t.tupleContent[j] = 0;
            	}
            	
                table[0][i] = t;
                table[0][i].addCoin(0);
                int differenceIndex = (eachCent[i] - numberOfDenominations[0]);
               
            //if there is no solution at the index of the difference, we set the table to a nullArray
                
                if(table[0][differenceIndex].length() == 0){
                    table[0][i] = new Tuple(nullArray);
                }
                
           // if there is a solution, we add the one coin solution to the solution at the difference index 
           // and store that tuple in the table.
                
                else {            		
                    table[0][i] = table[0][i].addTuples(table[0][differenceIndex]);
                }
            }  
        }
        
        //solve the rest of the problem for the rest of the denominations
        
        for (int j = 1; j < numberOfDenominations.length; j++){
        	for (int i = 1; i < eachCent.length; i++){
    	
        	//if the cent value is lower that than first coin value, a nullArray is set automatically to a null Array
        	// also checks the tuple above it so see if that is null as well
        	
        		if (eachCent[i] < numberOfDenominations[j]) {
        			if (table[j-1][i].length() == 0){
        				table[j][i] = new Tuple(nullArray);
        			} else {
        				table[j][i] = table[j-1][i];
        			}
        		}
            
            //otherwise we add a coin to the new tuple and compute the difference of the cent value and the denomination.
            
        		else {
        			
            	//sets the first value of the table to a tupleOfDenominations of zero
            	
        			int[] zeroTupleArray = new int [numberOfDenominations.length];
        			for (int p = 0; p < numberOfDenominations.length; p++){
        				zeroTupleArray[p] = 0;
        			}
        			table [j][0] = new Tuple (zeroTupleArray);
        			
        			Tuple t = new Tuple (tupleOfDenominations);
        			for (int k = 0; k < numberOfDenominations.length; k++){
        				t.tupleContent[k] = 0;
        			}
        			
        			// adds a coin and checks for a solution at the difference index and at the different index above 
            	
        			table[j][i] = t;
        			table[j][i].addCoin(j);
        			int differenceIndex = (eachCent[i] - numberOfDenominations[j]);
        			if(table[j][differenceIndex].length() == 0 && table[j - 1][i].length() == 0 ){
        				table[j][i] = new Tuple(nullArray);
        			}
        			if(table[j][differenceIndex].length() == 0 && table[j - 1][i].length() != 0 ){
        				table[j][i] = table[j-1][i];
        			}
        			
        			else {            		
        				table[j][i] = table[j][i].addTuples(table[j][differenceIndex]);
        			}
        			if (table[j-1][i].length() != 0 && table[j - 1][i].compareTuple() < table[j][i].compareTuple()){
        				table[j][i] = table[j-1][i];
        			}
        		}  
        	}
        }
    
        //sets the value for coinsString 
        
        for (int i = 0; i < numberOfDenominations.length; i++) {
        	 coinsString += numberOfDenominations[i];
        	 if (i < numberOfDenominations.length - 1) coinsString += ",";
        }
        
        // prints final result
        
        if (table[numberOfDenominations.length - 1][eachCent.length -1].length() == 0){
        	System.out.println("It is impossible to make " + Integer.parseInt(args[0]) + " with coins denominated " + coinsString);
        } else {
        	System.out.println("you can make " + Integer.parseInt(args[0]) + " with just " + table[numberOfDenominations.length - 1][eachCent.length -1].compareTuple() + " coin(s) like this: \n");
        	for (int i = 0; i < numberOfDenominations.length; i++) {
        		System.out.println(table[numberOfDenominations.length - 1][eachCent.length -1].tupleContent[i] + " " + numberOfDenominations[i] + "-" + "cent coins \n");
           }
        }
	}
}
