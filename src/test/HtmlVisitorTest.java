import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class HtmlVisitorTest
{
	@Test
	public void testTokenParser1() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("em");
        h.tokenParser(t);
        assertEquals(t.getContent(),"<em>");
	}
	@Test
	public void testTokenParser1_2() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("/em");
        h.tokenParser(t);
        assertEquals(t.getContent(),"</em>");
	}
	@Test
	public void testTokenParser1_3() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("strong");
        h.tokenParser(t);
        assertEquals(t.getContent(),"<strong>");
	}
	@Test
	public void testTokenParser1_4() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("/strong");
        h.tokenParser(t);
        assertEquals(t.getContent(),"</strong>");
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

    @Test
    public void testTokenParser6() {  //br
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("br");
        h.tokenParser(t);

        assertEquals(t.getContent(),"<br>");
    }
    @Test
    public void testTokenParser7() {  //visit style
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("hello");
//        h.tokenParser(t);
		h.visit(t);
      //  assertEquals(t.getContent(),"");
    }
    @Test
    public void testTokenParser8() {  //visitPLAIN
        HTMLVisitor h = new HTMLVisitor();
        h.setLine("hello");
        StyleText t = new StyleText("wrong");
//        h.tokenParser(t);
		h.visit(t);
       // assertEquals(t.getContent(),"null");
    }

        @Test
	    public void testHeader() {

	        HTMLVisitor h = new HTMLVisitor();
	        Header header = new Header();
	        ArrayList<Node> node = new ArrayList<Node>();
	        header.htype=1;

			Text dummy = new Text();
			node.add(dummy);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(header);

			node.add(header);
			h.setNodelist(node);
			h.setSequence(1);
			h.setTempNode();
			h.visit(header);
			assertEquals(h.getLine(),"<h1></h1>");

			PlainText text = new PlainText();
			text.setContent("hi");
			header.addToken(text);
			node.add(header);
			h.setNodelist(node);
			h.setSequence(2);
			h.setTempNode();
			h.visit(header);

	       // header.accept(h);
	        assertEquals(h.getLine(),"<h1>hi</h1>");
    }

        @Test
	    public void testItemList() {
	        HTMLVisitor h = new HTMLVisitor();
	        ItemList list = new ItemList();
	        ArrayList<Node> node = new ArrayList<Node>();

			PlainText text = new PlainText();
			text.setContent("hi");
			list.addToken(text);

			Text dummy = new Text();
			node.add(dummy);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(list);

			node.add(list);
			h.setNodelist(node);
			h.setSequence(1);
			h.setTempNode();
			h.visit(list);
			assertEquals(h.getLine(),"<li>hi</li>");
    }

    @Test
		public void testOrederedList1() {
			HTMLVisitor h = new HTMLVisitor();
			OrderedList list = new OrderedList();
			ArrayList<Node> node = new ArrayList<Node>();

			Text dummy = new Text();
			node.add(dummy);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(list);

			node.add(list);
			h.setNodelist(node);
			h.setSequence(1);
			h.setTempNode();
			h.visit(list);

			PlainText text = new PlainText();
			text.setContent("hi");
			list.addToken(text);

			node.add(list);
			h.setNodelist(node);
			h.setSequence(2);
			h.setTempNode();
			h.visit(list);

			node.add(list);
			h.setNodelist(node);
			h.setSequence(3);
			h.setTempNode();
			h.visit(list);

			assertEquals(h.getLine(),"<li>hi</li>");
    }

    @Test
		public void testOrederedList2() {
			HTMLVisitor h = new HTMLVisitor();
			OrderedList list = new OrderedList();
			ArrayList<Node> node = new ArrayList<Node>();

			Text dummy = new Text();
			node.add(dummy);
			node.add(list);
			node.add(list);
			node.add(list);
			node.add(dummy);
			h.setNodelist(node);

			h.setSequence(0);
			h.setTempNode();
			h.visit(list);

			h.setSequence(1);
			h.setTempNode();
			h.visit(list);

			h.setSequence(2);
			h.setTempNode();
			h.visit(list);

			h.setSequence(3);
			h.setTempNode();
			h.visit(list);

    }
        @Test
	    public void testHorizontal() {

			Text dummy = new Text();
	        HTMLVisitor h = new HTMLVisitor();
	        HorizontalRule hr = new HorizontalRule();
	        ArrayList<Node> node = new ArrayList<Node>();

			node.add(dummy);
			node.add(hr);
			h.setNodelist(node);

			h.setSequence(0);
			h.setTempNode();
			h.visit(hr);

			h.setSequence(1);
			h.setTempNode();
			h.visit(hr);

	        assertEquals(h.getLine(),"<HR>");
    }

        @Test
	    public void testText() {

	        HTMLVisitor h = new HTMLVisitor();
			Text dummy = new Text();
			HorizontalRule hr = new HorizontalRule();

	        ArrayList<Node> node = new ArrayList<Node>();

			PlainText text = new PlainText();
			text.setContent("hi");
			dummy.addToken(text);
			node.add(dummy);
			node.add(hr);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(dummy);
			h.setSequence(1);
			h.setTempNode();
			h.visit(dummy);

	        assertEquals(h.getLine(),"hi");
    }
		@Test
	    public void testCodeBlock() {
	        HTMLVisitor h = new HTMLVisitor();
			Text dummy = new Text();
			CodeBlock cb = new CodeBlock();

	        ArrayList<Node> node = new ArrayList<Node>();

			node.add(dummy);
			node.add(cb);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(cb);
			h.setSequence(1);
			h.setTempNode();
			h.visit(cb);
   		}
		@Test
	    public void testBlockQuotes1() {

	        HTMLVisitor h = new HTMLVisitor();
			Text dummy = new Text();
			BlockQuotes bq = new BlockQuotes();

	        ArrayList<Node> node = new ArrayList<Node>();

			PlainText text = new PlainText();
			text.setContent("hi");
			bq.addToken(text);

			node.add(dummy);
			node.add(bq);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(bq);
			h.setSequence(1);
			h.setTempNode();
			h.visit(bq);
    	}
		@Test
	    public void testBlockQuotes2() {

	        HTMLVisitor h = new HTMLVisitor();
			Text dummy = new Text();
			BlockQuotes bq = new BlockQuotes();

	        ArrayList<Node> node = new ArrayList<Node>();

			node.add(dummy);
			node.add(bq);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(bq);
			h.setSequence(1);
			h.setTempNode();
			h.visit(bq);
    	}
	@Test
	public void testMethod(){

	        HTMLVisitor h = new HTMLVisitor();
			Text dummy = new Text();
			BlockQuotes bq = new BlockQuotes();

	        ArrayList<Node> node = new ArrayList<Node>();
			h.setLine("ff");
			node.add(dummy);
			node.add(bq);
			h.setNodelist(node);
			h.setSequence(0);
			h.setTempNode();
			h.visit(bq);
			h.setSequence(1);
			h.setTempNode();
			h.visit(bq);
			int i = h.getNodeIndex();
			ArrayList<Node> text = h.getNode();
			Document document = new Document();
			h.visit(document);

	}

}
