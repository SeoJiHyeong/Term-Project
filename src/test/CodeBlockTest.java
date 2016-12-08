import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class CodeBlockTest
{
	@Test
	public void testCodeBlockInstance() {
        CodeBlock b = new CodeBlock();
        assertEquals(b.notifyNode(),"CodeBlock");
	}


	
}
