import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class PlainTextTest
{
	@Test
	public void testNotice() {
        PlainText t = new PlainText();
        assertEquals("plaintext",t.notifyToken());
	}
}
