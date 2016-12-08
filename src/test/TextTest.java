import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class TextTest
{
	@Test
	public void testNotice() {
        Text t = new Text();
        assertEquals("Text",t.notifyNode());
	}
}
