package com.billsampas.assignment;

import org.junit.Test;

import com.billsampas.assignment.HelperFunctions;

public class RandomListExceptionTests {
	@Test(expected = IllegalArgumentException.class)
	public void invalidRangeExceptionTest() {
		HelperFunctions.createRandomList(10,4,4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void indexOutOfBoundsExceptionTest() {
		HelperFunctions.createRandomList(-1,4,14);
	}
}