package Assignment;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Assignment.HelperFunctions;

@RunWith(Parameterized.class)
public class RandomListSpecificationTests {

	@Parameterized.Parameter(0)
    public int size;
    @Parameterized.Parameter(1)
    public int min;
    @Parameterized.Parameter(2)
    public int max;
    
    @Parameterized.Parameters(name = "{index}: Test with size={0}, min ={1}, max ={2} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 2, 5}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.asList(data);
    }

    @Test
    public void listSpecificationsTest() {
    	List<Integer> numbers=HelperFunctions.createRandomList(size,min,max);
        assertThat(numbers, hasSize(size));
        assertThat(numbers, everyItem(greaterThanOrEqualTo(min)));
        assertThat(numbers, everyItem(lessThan(max)));
    }
}
