import java.util.ArrayList;

class EmptySListException  extends RuntimeException {
	public EmptySListException( String s)    {        
		super(s);    
	}
}

public class SList<E> {

	//fields
	private ArrayList<E> list;
	private int length;
	
	
	//constructors
	public SList()	{
		this.list = new ArrayList<E>();
		this.length = 0;
	}
	
	/*this constructor is private as it is only meant to be 
	 * used in the SList class. */
	private SList(ArrayList<E> inputList)	{
		this.list = (ArrayList<E>) inputList;
		this.length = inputList.size();
	}
	
	//methods
	public E head(){
		if (this.isEmpty())
			throw new EmptySListException("SList Exception");
		else
			return (E) this.getArrayList().get(0);
	}
	
	public <E> SList<E> tail(){
		ArrayList<E> newArrayList = (ArrayList<E>) this.getArrayList().clone();
		newArrayList.remove(0);
		SList<E> newSList = new SList(newArrayList);
		return newSList;
	}

	/*Making a copy or original SList's arrayList.
	 * making changes to the new arrayList. create new SList to hold 
	 * new array list 	 */
	public <E> SList<E> cons(E newItem)	{
		/*the arrayList clone method has a return type of object 
		 * so it must be casted to ArrayList<E> */
		ArrayList<E> newArrayList = (ArrayList<E>) this.getArrayList().clone();
		newArrayList.add(0,newItem);
		SList<E> newSList = new SList(newArrayList);
		return newSList;
	}
	
	public boolean isEmpty()	{
		if (length > 0)
			return false;
		else	
			return true;
	}
	
	public int length() {
		return getLength();
	}
	
	public String toString()	{
		return this.getArrayList().toString();
	}
	
	
	//getter methods
	private ArrayList<E> getArrayList()	{
		return this.list;
	}
	
	private int getLength()	{
		return this.length;
	}
}
