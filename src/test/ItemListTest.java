import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class ItemListTest
{
	@Test
	public void testItemListInstance() {
        ItemList b = new ItemList();
        assertEquals(b.notifyNode(),"ItemList");
	}


	
}
