package Assignment;

import org.junit.Test;

import Assignment.HelperFunctions;

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