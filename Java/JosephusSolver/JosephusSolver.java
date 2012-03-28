public class JosephusSolver {
	
	public static void main ( String[] args ){
		int n = Integer.parseInt( args[0] );
		int k = Integer.parseInt( args[1] ) + 1;
		LinkedCircularList circleOfFolks = new LinkedCircularList();
		for (int i = 0; i < n; i++) circleOfFolks.add(i);
		ListElement ptr = circleOfFolks.getFirst();
		while ( circleOfFolks.size() > 1 ){
			for ( int i = 0; i < k; i++ ) {
				if ( i == (k - 1)){
					circleOfFolks.remove(ptr.getData());
					ptr = ptr.getNext();
				}
				else {
					ptr = ptr.getNext();
				}
			}
		} 
		System.out.println("The person at index; " + circleOfFolks.toString() + " is the survivor!");
	}
}