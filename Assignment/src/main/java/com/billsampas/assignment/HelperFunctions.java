package com.billsampas.assignment;

import java.util.Random;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Set;

/**
 * This library contains generic purpose methods that can be useful
 * outside the current assignment, and thus placed on their own file
 */
public class HelperFunctions {
	
	
	
    /** Creates a list of random integers
     * @param size The number of elements.
     * @param min The minimum value of the random integers
     * @param max The maximum value of the random integers
    */
    public static List<Integer> createRandomList(int size, int min, int max) {
    	return new Random().ints(size,min,max).boxed().collect(Collectors.toList());
    }
    
    /** Calculates the intersection of two lists
     * @param a The first list.
     * @param b The second list.
    */
    public static <T> Set<T> intersect(List<T> hashedList, List<T> iteratedList){
    	Set<T> setA = new HashSet<T>(hashedList);
    	// We use a set for the intersection because it filters outs any duplicate values automatically
    	Set<T> resultSet=new HashSet<T>(hashedList.size());
    	for (T current:iteratedList)
    		if(setA.contains(current))
    			resultSet.add(current);
    	return resultSet;
    }
    
    
    
}
