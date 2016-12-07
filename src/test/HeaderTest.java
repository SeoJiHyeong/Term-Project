import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class HeaderTest
{
	@Test
	public void testHeaderInstance() {
        Header b = new Header();
        assertEquals(b.notifyNode(),"Header");
	}


	
}
