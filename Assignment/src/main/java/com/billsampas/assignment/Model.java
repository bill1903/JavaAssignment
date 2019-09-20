package com.billsampas.assignment;

import java.util.List;
import java.util.Set;

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
	boolean isAHashed;
	
	public Model(int listASize, int listBSize, boolean isListAHashed) {
		setListASize(listASize);
		setListBSize(listBSize);
		if(isListAHashed)
			setListAHashed();
		else
			setListBHashed();
	}
	
	// Getters
	public int getMinElementValue() {
		return minValue;
	}
	public int getMaxElementValue() {
		return maxValue;
	}
	
	
	
	public int getListASize() {
		return listASize;
	}
	
	public int getListBSize() {
		return listBSize;
	}
	
	public boolean isListAHashed() {
		return isAHashed;
	}
	
	public boolean isListBHashed() {
		return !isAHashed;
	}
	
	public void setListAHashed() {
		isAHashed=true;
	}
	public void setListBHashed() {
		isAHashed=false;
	}
	
	
	
	public void setListASize(int size) {
		listASize=Math.max(0, size);
	}
	
	public void setListBSize(int size) {
		listBSize=Math.max(0, size);
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
        Set<Integer> result;
        if(isListAHashed()) {
        	System.out.println("A list");
        	result = HelperFunctions.intersect(a, b);
        }
        else {
        	System.out.println("B list");
        	result = HelperFunctions.intersect(b, a);
        }
        long endTime = System.nanoTime();
		return new RunInfo(result.size(), endTime-startTime);
		
	}
	
}
	
	
	
