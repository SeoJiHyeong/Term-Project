import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class LineFeedTest
{
	@Test
	public void testLineFeed() {
        LineFeed b = new LineFeed();
        assertEquals(b.notifyNode(),"LineFeed");
	}


	
}
