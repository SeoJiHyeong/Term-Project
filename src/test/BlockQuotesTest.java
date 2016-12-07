import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class BlockQuotesTest
{
	@Test
	public void testBlockQuotesInstance() {
        BlockQuotes b = new BlockQuotes();
        assertEquals(b.notifyNode(),"BlockQuotes");
	}


	
}
