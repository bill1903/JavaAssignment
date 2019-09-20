package com.billsampas.assignment;

import java.util.Random;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;

import java.util.Set;

/**
 * This library contains generic purpose methods that can be useful
 * outside the current assignment, and thus placed on their own file
 */
public class HelperFunctions {
	
	/** Populates a JComboBox using an enum
     * @param comboBox The JComboBox we want to populate.
     * @param enumClass The class of the enum
     * @param selectedValue The defaultValue
    */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <E extends Enum<E>> void populateComboWithEnumValues(JComboBox comboBox, Class<E> enumClass, E selectedValue) {
	    for (Enum<E> enumVal: enumClass.getEnumConstants())
	    	comboBox.addItem(enumVal);
	    comboBox.setSelectedItem(selectedValue);
	}
	
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
