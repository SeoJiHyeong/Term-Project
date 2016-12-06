import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class PlainVisitorTest
{
    
	@Test
	public void testEmphasis_1() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "__test__";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
	}

    @Test
    public void testEmphasis_0() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "__test";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("__test",tokenList.get(0).getContent());
    }


    @Test
    public void testEmphasis_2() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "**test**";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
    }
    
    @Test
    public void testEmphasis_3() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "__test_h";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(2).getContent());
    }
    
    @Test
    public void testEmphasis_4() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "**test*h";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(2).getContent());
    }
    
    @Test
    public void testEmphasis_5() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "hi___hi";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi___hi",tokenList.get(0).getContent());
    }
    
    
    @Test
    public void testEmphasis_6() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "hi***hi";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi***hi",tokenList.get(0).getContent());
    }
    
    @Test
    public void testEmphasis_7() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "hi**hi";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
    }
    
    @Test
    public void testEmphasis_8() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "hi__hi";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
    }
    
    
    @Test
    public void testItalic() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "_test_";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
    }

    @Test
    public void testItalic2() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "*test*";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
    }
    @Test
    public void testItalic3() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "h_h_";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("h",tokenList.get(0).getContent());
    }
    @Test
    public void testItalic4() {
        PlainVisitor p = new PlainVisitor();
        String tmp = "h*h*";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("h",tokenList.get(0).getContent());
    }
}
