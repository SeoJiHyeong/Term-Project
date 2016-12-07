import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class OrderedListTest
{
	@Test
	public void testOrderedListInstance() {
        OrderedList o = new OrderedList();
        assertEquals(o.notifyNode(),"OrderedList");
	}
    
    @Test
    public void testSetNumber(){
        OrderedList o = new OrderedList();
        o.setNumber(1);
        assertEquals(o.getNumber(),1);
    }


	
}
