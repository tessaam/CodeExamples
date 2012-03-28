import java.util.Iterator;

public interface CircularList{
	
	public void add( int i );
	public void clear();
	public boolean contains( int i );
	public boolean equals( Object o ); 
	public boolean isEmpty();
	public Iterator iterator();
	public void remove( int i );
	public int size();
	public Integer[] toArray();
	public String toString();
	
}