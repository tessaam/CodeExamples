import java.util.Iterator;

public class LinkedCircularList {

    private int size;
	private ListElement first;
	private ListElement last;
	private ListElement previous;
	private ListElement nextElement;

    //constructs a new Circular LinkedList with size 0
    public LinkedCircularList() {
        size = 0;
        first = null;
	}
	
	//adds new integer to the LinkedCircularList
    public void add ( int i ) {
       if (size < 1){
       		first = new ListElement (i, first);
    		size++;
    		previous = first;
    	}
    	else { 
    		nextElement = new ListElement (i, first);
    		previous.next = nextElement;
    		size++;
    		previous = nextElement;
    		last = nextElement;
    	}
    }
        	
   	//sets LinkedCircularList to a new LinkedCircularList with size 0;
  	public void clear(){
    	this.size = 0;
    } 
    
    //checks the LinkedCircularList for the integer given in the parameter
    public boolean contains (int i){
    	int counter = 0;
    	ListElement ptr = first;
		while ( counter < this.size - 1 ) {
            if (ptr.getData() == i) return true;
            else {
				ptr = ptr.getNext();
				counter++;
			}
		}
		return false;
    }
    
    //returns boolean value if the object is equal to "this"
    public boolean equals (Object o){   
    	return ( this.hashCode() == o.hashCode() );
    }
    
    //returns true if LinkedCircularList has zero ListElements
    public boolean isEmpty(){
    	return (this.size() == 0);
    }
    
    //iterates through the LinkedCircularList
    public Iterator iterator(){
       return new SpecialIterator(this);
    } 
    
    //removes the given integer from the LinkedCircularList
    public void remove (int i){
    	ListElement ptr = this.first;
		while ( ptr != null ){
			if (ptr.getData() == i){
				while (ptr.getNext().getData() != i){
					ptr = ptr.getNext();	
				}
				ListElement tempNext = ptr.getNext().getNext();
				ptr.setNext(tempNext);
				first = tempNext;
				size--;
				break;
			}
			if (ptr.getNext().getData() == i){
				ListElement tempNext = ptr.getNext();
				ptr.setNext(tempNext.getNext());
				size--;
				break;
			}
			else {
				ptr = ptr.getNext();
			}
		}	
   }
    
    //returns the size of the LinkedCircularList
  	public int size(){
		return this.size;	
    }
    
    //returns an integer[] of the LinkedCircularList
    public Integer[] toArray(){
    	 int counter = 0;
    	 Integer[] a = new Integer [this.size];
    	 ListElement ptr = first;
		 for (int i = 0; i < this.size; i++) {
            a[i] = ptr.getData();
			ptr = ptr.getNext();
			counter++;
		    }
		return a;
    } 
    
    //returns a stringified version of the LinkedCircularList
    public String toString () {
    	int counter = 0;
        if ( size == 0 ) { return "<>"; }
        else {
            String s = String.valueOf ( first.getData() );
            ListElement ptr = first.getNext();
		    while ( counter < this.size() - 1 ) {
                s = s + "," + String.valueOf ( ptr.getData() );
				ptr = ptr.getNext();
				counter++;
		    }
		    return "< " + s + " >";
        }
    }
    
    //returns the data from the current ListElement
    public int getData(ListElement le){
    	return le.getData();
    }
    
    //moves to the next ListElement
    public ListElement getNext(ListElement le){
    	return le.getNext();
    }
    
      //moves to the next ListElement
    public ListElement getFirst(){
    	return this.first;
    }
    
    class SpecialIterator implements java.util.Iterator {
    	
    	private LinkedCircularList cll; 	
    	private ListElement cursor;
    	
    	public SpecialIterator (LinkedCircularList a){
    		this.cll = a;
    		this.cursor = a.getFirst();
    	}
    	
    	//LinkedCircularLists will always have a next
    	public boolean hasNext(){
    		return true;
    	}
    	
    	//returns value of next 
    	public Object next(){
    		cursor = cursor.getNext();
    		return this.cursor.getData();
    	}
    	
    	//did not find this method necessary
    	public void remove(){
    		throw new UnsupportedOperationException();
    	}
    }
    
}