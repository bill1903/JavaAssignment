package Assignment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Assignment.HelperFunctions;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(Parameterized.class)
public class IntersectionTests {
    @Parameterized.Parameter(0)
    public List<Integer> listA;
    @Parameterized.Parameter(1)
    public List<Integer> listB;
    @Parameterized.Parameter(2)
    public List<Integer> intersection;
    
    
    @Parameterized.Parameters(name = "{index}: Test with listA={0}, listB ={1}, intersection ={2} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
	        	{	new ArrayList<Integer>(List.of(1,2,2,3,6,12,12,1,-5)),
	        		new ArrayList<Integer>(List.of(1,2,2,44,4,2,123)),
	        		new ArrayList<Integer>(List.of(2,1))
	        	},
	        	{	new ArrayList<Integer>(List.of(1,2,3)),
	        		new ArrayList<Integer>(List.of(1,4,2)),
	        		new ArrayList<Integer>(List.of(1,2))
	        	},
	        	{	new ArrayList<Integer>(List.of(1,2,3)),
	        		new ArrayList<Integer>(List.of(4,5,6)),
	        		new ArrayList<Integer>()
	        	}
	        };
        return Arrays.asList(data);
    }
    
	@Test
	public void intersectionTest() {
		List<Integer> actual=HelperFunctions.intersect(listA,listB);
        
        assertThat(actual, hasSize(intersection.size()));
        
        assertThat(actual, containsInAnyOrder(intersection.toArray()));
	}

}
