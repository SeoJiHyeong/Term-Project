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
        p = new PlainVisitor();
         tmp = "__test";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("__test",tokenList.get(0).getContent());
         p = new PlainVisitor();
         tmp = "**test**";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
         p = new PlainVisitor();
         tmp = "__test_h";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(2).getContent());
        p = new PlainVisitor();
         tmp = "**test*h";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(2).getContent());
         p = new PlainVisitor();
         tmp = "hi___hi";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi___hi",tokenList.get(0).getContent());
         p = new PlainVisitor();
         tmp = "hi***hi";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi***hi",tokenList.get(0).getContent());
         p = new PlainVisitor();
         tmp = "hi**hi";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
         p = new PlainVisitor();
         tmp = "hi__hi";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
        p = new PlainVisitor();
        
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
        p = new PlainVisitor();
        tmp = "*test*";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("test",tokenList.get(1).getContent());
        p = new PlainVisitor();
        tmp = "h_h_";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("h",tokenList.get(0).getContent());
         p = new PlainVisitor();
         tmp = "h*h*";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("h",tokenList.get(0).getContent());
    }
    
    @Test
    public void testVisitItemList1(){
        ItemList h = new ItemList();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("-");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("-gggg");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
     
        v.setLine("+gggg");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("*gggg");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("!!gggg");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        
    }

    @Test
    public void testVisitItemList2(){
        ItemList h = new ItemList();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("- gggg");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("gggg",tokenList.get(0).getContent());
        
        
        v.setLine("+ gggg");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("gggg",tokenList.get(0).getContent());
        
        v.setLine("* gggg");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("gggg",tokenList.get(0).getContent());
        
    }
    
    
    @Test
    public void testOrderedList(){
        OrderedList h = new OrderedList();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("1. hi");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        System.out.println("##################################");
        System.out.println(tokenList.get(0).getContent());
        System.out.println("##################################");
        
    }
    
    @Test
    public void testVisitCodeBlock1(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("	codeblockkkk");
        v.visit(c);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("codeblockkkk",tokenList.get(0).getContent());
        
        v.setLine("   codeblockkkk");
        v.visit(c);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("codeblockkkk",tokenList.get(0).getContent());
    }
    
    @Test
    public void testVisitCodeBlock2(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("codeblockkkk");
        v.visit(c);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
}
