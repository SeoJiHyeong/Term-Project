import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class HTMLVisitorTest
{
	@Test
	public void testTokenParser1() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("em");
        h.tokenParser(t);
        assertEquals(t.getContent(),"<em>");
	}

    @Test
    public void testTokenParser2() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("link");
        h.tokenParser(t);
        
        assertEquals(t.getContent(),"<a href=\"null\">");
    }
	
    @Test
    public void testTokenParser3() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("/link");
        h.tokenParser(t);
        
        assertEquals(t.getContent(),"null</a>");
    }
    
    @Test
    public void testTokenParser4() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("image");
        h.tokenParser(t);
        
        assertEquals(t.getContent(),"<img src=\"null\"");
    }
    
    @Test
    public void testTokenParser5() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("/image");
        h.tokenParser(t);
        
        assertEquals(t.getContent()," alt=\"null\">");
    }
}
