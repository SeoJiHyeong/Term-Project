import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class NodeTest
{
	@Test
	public void testContent() {
        Node n = new Node();
        n.addContent("123");
        assertEquals("123",n.getContent(0));
	}

    @Test
    public void testLine(){
        Node n = new Node();
        n.setLine("123");
        assertEquals("123",n.getLine());
    }
    
    @Test
    public void testToken(){
        Node n = new Node();
        Token t = new Token();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        n.addToken(t);
        tokenList = n.getTokenList();
        assertEquals(t,tokenList.get(0));
        
    }

	
}
