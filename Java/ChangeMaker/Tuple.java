
public class Tuple {
public int [] tupleContent;
	
	//creates a tuple from a given int[]

	public Tuple (int [] tupleArray){
		this.tupleContent = tupleArray;
	}
	
	// adds a single coin to the given index
	
	public Tuple addCoin (int index){
		this.tupleContent[index] = this.tupleContent[index] + 1;
		return this;
	}
	
	// sums the total number of coins in a tuple
	
	public int compareTuple (){
		int tupleTotal = 0;
		for (int i = 0; i < this.tupleContent.length; i++){
			tupleTotal += this.tupleContent[i];
		}
		return tupleTotal;
	}
	
	// adds each index in two different tuples
	
	public Tuple addTuples (Tuple t){
		int[] addArray = new int[t.tupleContent.length];
		Tuple addedTuple = new Tuple(addArray);
		for (int i = 0; i < t.tupleContent.length; i++){
			addedTuple.tupleContent[i] = (this.tupleContent[i] + t.tupleContent[i]);
		}
		return addedTuple;
	}

	// returns a stringified tuple
	
	public String toString (){
		String tupleString = "";
		for (int i = 0; i < this.tupleContent.length; i++){
			tupleString += "(";
			tupleString += this.tupleContent[i];
			tupleString += ")";
		}
		return tupleString;
	}
	
	// returns the length of the tuple
	
	public int length() {
		return this.tupleContent.length;
	}
}
