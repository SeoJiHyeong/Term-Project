import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class HorizontalRuleTest
{
	@Test
	public void testHorizontalRuleInstance() {
        HorizontalRule b = new HorizontalRule();
        assertEquals(b.notifyNode(),"HorizontalRule");
	}


	
}
