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
        
        p = new PlainVisitor();
        p.setLine("dafadf  ");
        tmp = "hi__hi";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
        p = new PlainVisitor();
        
        p = new PlainVisitor();
        p.setLine("dafadf 1");
        tmp = "hi__hi";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
        p = new PlainVisitor();
        
        p = new PlainVisitor();
        p.setLine("dafadf1 ");
        tmp = "hi__hi";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("hi",tokenList.get(0).getContent());
        p = new PlainVisitor();
        
        p = new PlainVisitor();
        p.setLine("dafadf");
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
    public void testBackSlashEscape(){
        PlainVisitor p = new PlainVisitor();
        String tmp = "\\*";
        Text nod = new Text();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("*",tokenList.get(0).getContent());
        
         p = new PlainVisitor();
         tmp = "asdf\\*";
         nod = new Text();
         nodeList = new ArrayList<Node>();
         tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        tokenList = nod.getTokenList();
        assertEquals("*",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "\\";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        assertEquals(1,nod.getTokenList().size());
        
        p = new PlainVisitor();
        tmp = "\\1";
        nod = new Text();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        nodeList = p.getNode();
        assertEquals(1,nod.getTokenList().size());
    }
    @Test
    public void testLink(){
        PlainVisitor p = new PlainVisitor();
        String tmp = "<http://www.naver.com>";
        Node nod = new Node();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("http://www.naver.com",tokenList.get(0).getContent());
    
        
        p = new PlainVisitor();
        tmp = "dfjlakdjfk <http://www.naver.com>";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("http://www.naver.com",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "click : [naver](http://www.naver.com)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("http://www.naver.com",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "[naver](http://www.naver.com)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("naver",tokenList.get(1).getContent());
        
        
        p = new PlainVisitor();
        tmp = "asdfsdf![N|Solid](/path/to/img.jpg \"Optional title\")";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("/path/to/img.jpg ",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "asdfsdf![N|Solid](/path/to/img.jpg)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("/path/to/img.jpg",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "![N|Solid](/path/to/img.jpg)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("N|Solid",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "![N|Solid](/path/to/img.jpg \"Optional title\")";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("/path/to/img.jpg ",tokenList.get(0).getContent());
        
        p = new PlainVisitor();
        tmp = "click : [naver](htt://www.naver.com)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        
        assertEquals("naver](htt://www.naver.com)",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "[naver](htt://www.naver.com)";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        
        assertEquals("naver](htt://www.naver.com)",tokenList.get(0).getContent());
        
        p = new PlainVisitor();
        tmp = "<htt://www.naver.com>";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("htt://www.naver.com>",tokenList.get(0).getContent());
        
        
        p = new PlainVisitor();
        tmp = "dfjlakdjfk <htt://www.naver.com>";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        assertEquals("htt://www.naver.com>",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "asdfsdf![N|Solid(/path/to/img.jpg \"Optional title\")";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        
        assertEquals("N|Solid(/path/to/img.jpg \"Optional title\")",tokenList.get(1).getContent());
        
        p = new PlainVisitor();
        tmp = "![N|Solid](/path/to/img.jpg \"Optional title\")";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        tokenList =nod.getTokenList();
        
        assertEquals("/path/to/img.jpg ",tokenList.get(0).getContent());

        
        p = new PlainVisitor();
        tmp = "!!!!";
        nod = new Node();
        nodeList = new ArrayList<Node>();
        tokenList = new ArrayList<Token>();
        p.tokenize(tmp,nod);
        
        assertEquals(0,nod.getTokenList().size());

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
        
        v.setLine("   gg");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine(" gg");
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
    public void testOrderedList2(){
        OrderedList h = new OrderedList();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("1.hi");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        
        v.setLine("1phi");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("p.hi");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("p");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("pppppppppp");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine("    pppppp");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
        
        v.setLine(" pppppp");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testOrderedList1(){
        OrderedList h = new OrderedList();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("1. hi");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        
        assertEquals("hi",tokenList.get(0).getContent());
        
        v.setLine("1. hi");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        
        assertEquals("hi",tokenList.get(0).getContent());
        
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
        
        v.setLine("    codeblockkkk");
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
    
    @Test
    public void testVisitCodeBlock6(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("    codeblockkkk");
        v.visit(c);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("codeblockkkk",tokenList.get(0).getContent());
        
    }
    @Test
    public void testVisitCodeBlock3(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("  ");
        v.visit(c);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testVisitCodeBlock4(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine(" 234 ");
        v.visit(c);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testVisitCodeBlock5(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("    ");
        v.visit(c);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testVisitCodeBlock7(){
        CodeBlock c = new CodeBlock();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("");
        v.visit(c);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
        
    @Test
    public void testBlockQuote1(){
        BlockQuotes q = new BlockQuotes();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine(">abc");
        v.visit(q);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("abc",tokenList.get(0).getContent());
    }
    
    @Test
    public void testBlockQuote2(){
        BlockQuotes q = new BlockQuotes();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("");
        v.visit(q);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    @Test
    public void testBlockQuote3(){
        BlockQuotes q = new BlockQuotes();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("!123");
        v.visit(q);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testBlockQuote4(){
        Header h = new Header();
        BlockQuotes q = new BlockQuotes();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("# h1");
        v.visit(h);
        v.visit(q);
        nodeList = v.getNode();
        assertEquals(2,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule1(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        v.addNode();
        v.setLine("----------");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals("----------",nodeList.get(1).getContent(0));
    }
    
    @Test
    public void testHorizontalRule2(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        v.addNode();
        v.setLine("*****************");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals("*****************",nodeList.get(1).getContent(0));
    }
    
    @Test
    public void testHorizontalRule3(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("-");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(2,nodeList.size());
        
    }
    
    @Test
    public void testHorizontalRule4(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        v.addNode();
        v.setLine("* * * * * *");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals("* * * * * *",nodeList.get(1).getContent(0));
    }
    
    @Test
    public void testHorizontalRule5(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        v.addNode();
        v.setLine("- - - - - -");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals("- - - - - -",nodeList.get(1).getContent(0));
    }
    
    @Test
    public void testHorizontalRule6(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("---*---");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule7(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("**-");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule8(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("** * -");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule9(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("-- - *");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule10(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    
    @Test
    public void testHorizontalRule11(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine(" ");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    @Test
    public void testHorizontalRule12(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("pppppp");
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(1,nodeList.size());
    }
    @Test
    public void testHorizontalRule13(){
        HorizontalRule h = new HorizontalRule();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        v.addNode();
        v.setLine("*****************");
        v.visit(h);
        v.visit(h);
        nodeList = v.getNode();
        assertEquals(2,nodeList.size());
    }
    
    @Test
    public void testHeader1(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("# h1");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("h1",tokenList.get(0).getContent());
    }
    
    @Test
    public void testHeader2(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("## h2");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("h2",tokenList.get(0).getContent());
    }
    
    @Test
    public void testHeader3(){
        Header h = new Header();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("adsfadsf");
        v.visit(t);
        v.setLine("========");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals("Header",nodeList.get(1).notifyNode());
       
    }

    @Test
    public void testHeader4(){
        Header h = new Header();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("adsfadsf");
        v.visit(t);
        v.setLine("=========1111");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals("Text",nodeList.get(1).notifyNode());
    }
    
    @Test
    public void testHeader5(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("############ h2");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals(1,nodeList.size());
        
        
    }
    
    
    @Test
    public void testHeader6(){
        Header h = new Header();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("adsfadsf");
        v.visit(t);
        v.setLine("------------");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals("Header",nodeList.get(1).notifyNode());
        
    }
    
    @Test
    public void testHeader7(){
        Header h = new Header();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("adsfadsf");
        v.visit(t);
        v.setLine("------------1111");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals("Text",nodeList.get(1).notifyNode());
    }
    
    @Test
    public void testHeader8(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("## h2 ##");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("h2",tokenList.get(0).getContent());
    }
    
    @Test
    public void testHeader9(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("## h2 #####");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("h2",tokenList.get(0).getContent());
    }
    
    @Test
    public void testHeader10(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("## h2#####");
        v.visit(h);
        nodeList = v.getNode();
        tokenList = nodeList.get(1).getTokenList();
        assertEquals("h2#####",tokenList.get(0).getContent());
    }
    
    @Test
    public void testHeader11(){
        Header h = new Header();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        v.addNode();
        v.setLine("");
        v.visit(h);
        nodeList = v.getNode();
        
        assertEquals(1,nodeList.size());
        
        
    }
    
    @Test
    public void testText(){
        Header h = new Header();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.addNode();
        v.setLine("# h1");
        v.visit(h);
        v.visit(t);
        nodeList = v.getNode();
        assertEquals(2,nodeList.size());
    }
    
    @Test
    public void testLineFeed(){
        LineFeed l = new LineFeed();
        Text t = new Text();
        PlainVisitor v = new PlainVisitor();
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        
        v.setLine("~");
        v.addNode();
        v.visit(l);
        v.visit(l);
        v.visit(t);
        v.visit(l);
        
        assertEquals("LineFeed",v.getNode().get(1).notifyNode());
    }
    
}
