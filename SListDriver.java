
public class SListDriver {
	
	public static <E extends Comparable<E> >boolean member (E item, SList<E> list) {
		
		//base case
		if (list.isEmpty() == true)	{
			return false;
		}
		
		else if (item.compareTo(list.head()) == 0) {
			return true;
		}

		//the new list is passed as an argument to the recursive function call.
		SList<E> newList = list.tail();
		
		//returns boolean value from recursive function calls
		return member(item, newList);

	}
	
	
	public static <E extends Comparable<E> > int countItems (E item, SList<E> list)	{
		int counter = 0;
		
		//base case
		if (list.isEmpty() == true)	
			return counter;
		
		else if (item.compareTo(list.head()) == 0) 
			counter++;
		
		//the new list will be passed as an argument to the recursive function call.
		SList<E> newList = list.tail();
		
		//summing all recursive function calls return values.
		return counter += countItems(item, newList);
	}
	
	public static void main(String[] args) {
		
		//This is TestCase A      
		System.out.println("\nTesting SList<Integer> ");      
		SList<Integer> myIntList = new SList<Integer>();      
		myIntList = myIntList.cons(2).cons(4).cons(8).cons(10).cons(4);      
		System.out.println("myIntList: " + myIntList);      
		System.out.println("head: "  + myIntList.head() + "\ttail: "  + myIntList.tail());     
		SList<Integer> blist =  myIntList.tail().tail().cons(9);      
		System.out.println( "blist: " + blist + "\nmyIntList: " + myIntList);      
		int x = 100;      
		System.out.print(x + " is a member of " + myIntList + ": " );      
		System.out.println( member(x,myIntList));      
		x = 4;      
		System.out.print("Number of times " + x + " appears in " + myIntList + ": " );      
		System.out.println(countItems(x,myIntList));      
		System.out.println("\nTesting SList<String>");      
		SList<String> myStringList = new SList<String>();      
		try {         
			String s1 = myStringList.head();      
		}      
		catch(EmptySListException e)      {         
			System.out.println(e);      
		}
	     myStringList = myStringList.cons("bird").cons("dog").cons("cat").cons("goldfish").cons("cat");      
	     System.out.println("\nmyStringList: " + myStringList);      
	     String a = "frog";      
	     System.out.print(a + " is a member of " + myStringList + ": " );     
	     System.out.println( member(a,myStringList));     
	     String b = "goldfish";      
	     System.out.print("Number of times " + b + " appears in " + myStringList + ": " );     
	     System.out.println(countItems(b,myStringList));    
	     System.out.println("Printing tails of myStringList");            
	     System.out.println(myStringList + "\t length: "+ myStringList.length());      
	     do      {        
	    	 myStringList = myStringList.tail();       
	    	 System.out.println(myStringList + "\t length: "+ myStringList.length());       
	     }      while( !myStringList.isEmpty());   
	     
	
		

		
	}
	
	

}
