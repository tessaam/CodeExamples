/* Constructor for a basic list element in a linked list */

public class ListElement {
	
        private int data;
        public ListElement next;

		//creates a new listelement
        public ListElement ( int i, ListElement ptr ) {
            this.data = i; this.next = ptr;		
        }
		
		//returns the data in the listelement
        public int getData () {
            return this.data;		
        }
		
		//returns the next ListElement
        public ListElement getNext () {
            return this.next;		
        }
        
        //sets the next listelement
        public void setNext (ListElement ptr){
        	this.next = ptr;
        }
}