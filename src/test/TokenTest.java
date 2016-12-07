import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class TokenTest
{
	@Test
	public void testContent() {
        Token t = new Token();
        t.setContent("123");
        assertEquals("123",t.getContent());
	}


	
}
