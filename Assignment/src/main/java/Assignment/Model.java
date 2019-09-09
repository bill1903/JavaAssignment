package Assignment;

import java.util.List;

/**
 * The Model component of the MVC pattern. It directly manages 
 * the data, logic and rules of the application.
 */
public class Model {
	private int listASize;
	private int listBSize;
	private int minValue=0, maxValue=1000;
	/* Since one list has to be hashed and the other has to be iterated,
	 * we only need to use a boolean to represent the 2 possible states
	 */
	private ListSelection hashedList;
	
	public Model(int listASize, int listBSize, ListSelection hashList) {
		// TODO Auto-generated constructor stub
		setListASize(listASize);
		setListBSize(listBSize);
		setHashedList(hashList);
	}
	
	// Getters
	public int getMinElementValue() {
		return minValue;
	}
	public int getMaxElementValue() {
		return maxValue;
	}
	
	public ListSelection getHashedList(){
		return hashedList;
	}
	
	public ListSelection getIteratedList() {
		return hashedList.OtherList();
	}
	
	public int getListASize() {
		return listASize;
	}
	
	public int getListBSize() {
		return listBSize;
	}
	
	// Setters
	public void setHashedList(ListSelection listSelection) {
		hashedList=listSelection;
	}
	
	public void setIteratedList(ListSelection listSelection) {
		hashedList=listSelection.OtherList();
	}
	
	public void setListASize(int size) {
		listASize=Math.max(0, size);
	}
	
	public void setListBSize(int size) {
		listBSize=Math.max(0, size);
	}
	
	public enum ListSelection{
		LISTA,LISTB;
		ListSelection OtherList() {
			return this==LISTA?LISTB:LISTA;
		}
		@Override
		  public String toString() {
		    switch(this) {
		      case LISTA: return "List A";
		      case LISTB: return "List B";
		      default: throw new IllegalArgumentException();
		    }
		  }
	}
	
	/**
	 * Contains information
	 */
	public class RunInfo {
	    int numberOfElements;
	    long timeNeeded;
	    public RunInfo(int numberOfElements, long timeNeeded) {
	    	this.numberOfElements=numberOfElements;
	    	this.timeNeeded=timeNeeded;
	    }
	    public int getNumberOfElements(){return numberOfElements;}
	    public long getTimeNeeded(){return timeNeeded;}
	}
	/** 
	 * Runs the intersection algorithm according to the model's specifications.
     * @return Returns a RunInfo instance with the number of elements in the intersection and the time needed
     * for them to be calculated. The time needed to populate the two lists is discounted
     * @see com.billsampas.assignment.RunInfo
    */
	public RunInfo RunIntersectionAlgorithm() {
		//populate the lists
		List<Integer> a = HelperFunctions.createRandomList(getListASize(), getMinElementValue(), getMaxElementValue());
        List<Integer> b = HelperFunctions.createRandomList(getListBSize(), getMinElementValue(), getMaxElementValue());
        // we only take into account the time needed to run the intersection algorithm, ignoring
        // the time needed to populate the 2 lists
        long startTime = System.nanoTime();
        List<Integer> result = HelperFunctions.intersect(a, b);
        long endTime = System.nanoTime();
		return new RunInfo(result.size(), endTime-startTime);
		
	}
	
}
	
	
	
