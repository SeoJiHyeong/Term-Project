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

        assertEquals(t.getContent(),"<a href=\"null\"/>");
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

        assertEquals(t.getContent()," alt=\"null\"");
    }

    @Test
    public void testTokenParser6() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("br");
        h.tokenParser(t);

        assertEquals(t.getContent(),"<br>");
    }
    @Test
    public void testTokenParser7() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("hello");

        h.visit(t);
        assertNull(h.getLine());
    }
    @Test
    public void testTokenParser8() {
        HTMLVisitor h = new HTMLVisitor();
        h.setLine("hello");
        StyleText t = new StyleText("wrong");

        h.visit(t);
        assertEquals("hellonull",h.getLine());

    }

    @Test
    public void testTokenParser9() {  //image_title
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("title");
        h.tokenParser(t);
        h.visit(t);
        assertEquals(t.notifyToken(),"title");
    }

    @Test
    public void testTokenParser10() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("code");
        h.tokenParser(t);

        assertEquals(t.getContent(),"<code>");
    }

    @Test
    public void testTokenParser11() {
        HTMLVisitor h = new HTMLVisitor();
        StyleText t = new StyleText("/code");
        h.tokenParser(t);

        assertEquals(t.getContent(),"</code>");
    }

    @Test
    public void testHeader() {

        HTMLVisitor h = new HTMLVisitor();
        Header header = new Header();
        Header header2 = new Header();
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
        assertEquals(h.getLine(),"<h1>"+""+"</h1>");
        PlainText text = new PlainText();
        text.setContent("hi");
        header2.addToken(text);
        node.add(header2);
        h.setNodelist(node);
        h.setSequence(2);
        h.setTempNode();
        h.visit(header2);

        assertEquals(h.getLine(),"<h0><h1></h1>hi</h0>");
    }
    @Test
    public void testLineFeed() {

        HTMLVisitor h = new HTMLVisitor();
        LineFeed lf = new LineFeed();
        ArrayList<Node> node = new ArrayList<Node>();

        Text dummy = new Text();
        node.add(dummy);
        h.setNodelist(node);
        h.setSequence(0);
        h.setTempNode();
        h.visit(lf);

        node.add(lf);
        h.setNodelist(node);
        h.setSequence(1);
        h.setTempNode();
        h.visit(lf);
        assertEquals(h.getLine(),null);

    }

    @Test
    public void testItemList1() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        ItemList list1 = new ItemList();
        list1.listLevel = 1;
        ItemList list2 = new ItemList();
        list2.listLevel = 2;
        ItemList list3 = new ItemList();
        list3.listLevel = 3;
        ItemList list4 = new ItemList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list1);
        node.add(list1);
        node.add(list2);
        node.add(list2);
        node.add(list3);
        node.add(list3);
        node.add(list1);
        node.add(list2);
        node.add(list3);
        node.add(list2);
        h.setNodelist(node);
        for(int i=1;i<node.size();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<li></li>\r\n</ul>\r\n</ul>");
    }

    @Test
    public void testItemList2() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        ItemList list1 = new ItemList();
        list1.listLevel = 1;
        ItemList list2 = new ItemList();
        list2.listLevel = 2;
        ItemList list3 = new ItemList();
        list3.listLevel = 3;
        ItemList list4 = new ItemList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list1);
        node.add(list1);
        node.add(list2);
        node.add(list2);
        node.add(list3);
        node.add(list3);
        node.add(list4);
        h.setNodelist(node);
        for(int i=1;i<node.size();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<ul>\r\n<li></li>\r\n</ul>\r\n</ul>\r\n</ul>\r\n</ul>");
    }

    @Test
    public void testItemList3() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        ItemList list1 = new ItemList();
        list1.listLevel = 1;
        ItemList list2 = new ItemList();
        list2.listLevel = 2;
        ItemList list3 = new ItemList();
        list3.listLevel = 3;
        ItemList list4 = new ItemList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list2);
        node.add(list1);
        node.add(list4);
        node.add(list1);
        node.add(dummy);
        h.setNodelist(node);
        for(int i=1;i<node.size();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<ul>\r\n<li>hi</li>\r\n</ul>");
    }

    @Test
    public void testOrederedList1() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        OrderedList list1 = new OrderedList();
        list1.listLevel = 1;
        OrderedList list2 = new OrderedList();
        list2.listLevel = 2;
        OrderedList list3 = new OrderedList();
        list3.listLevel = 3;
        OrderedList list4 = new OrderedList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list1);
        node.add(list1);
        node.add(list2);
        node.add(list2);
        node.add(list3);
        node.add(list2);
        node.add(list1);
        h.setNodelist(node);

        for(int i=1;i<h.getNodeIndex();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<li>hi</li>\r\n</ol>");
    }

    @Test
    public void testOrederedList2() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        OrderedList list1 = new OrderedList();
        list1.listLevel = 1;
        OrderedList list2 = new OrderedList();
        list2.listLevel = 2;
        OrderedList list3 = new OrderedList();
        list3.listLevel = 3;
        OrderedList list4 = new OrderedList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list1);
        node.add(list1);
        node.add(list2);
        node.add(list2);
        node.add(list3);
        node.add(list3);
        node.add(list4);
        h.setNodelist(node);

        for(int i=1;i<h.getNodeIndex();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<ol>\r\n<li></li>\r\n</ol>\r\n</ol>\r\n</ol>\r\n</ol>");
    }

    @Test
    public void testOrederedList3() {
        HTMLVisitor h = new HTMLVisitor();
        ArrayList<Node> node = new ArrayList<Node>();

        PlainText plaintext = new PlainText();
        plaintext.setContent("hi");

        OrderedList list1 = new OrderedList();
        list1.listLevel = 1;
        OrderedList list2 = new OrderedList();
        list2.listLevel = 2;
        OrderedList list3 = new OrderedList();
        list3.listLevel = 3;
        OrderedList list4 = new OrderedList();
        list4.listLevel = 4;

        PlainText text = new PlainText();
        text.setContent("hi");
        Text dummy = new Text();
        list1.addToken(plaintext);
        node.add(dummy);
        node.add(list3);
        node.add(list1);
        node.add(list4);
        node.add(dummy);
        h.setNodelist(node);

        for(int i=1;i<h.getNodeIndex();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(list1);
        }
        assertEquals(h.getLine(),"<ol>\r\n<li></li>\r\n</ol>\r\n</ol>");
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

        assertEquals(h.getLine(),"<hr>");
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
        node.add(dummy);
        node.add(dummy);
        node.add(hr);
        node.add(dummy);

        h.setNodelist(node);

        for(int i=1;i<node.size();i++){
            h.setSequence(i);
            h.setTempNode();
            h.visit(dummy);
        }

        assertEquals(h.getLine(),"<p><p>hihi</p>hi</p>");
    }
    @Test
    public void testCodeBlock() {
        HTMLVisitor h = new HTMLVisitor();
        Text dummy = new Text();
        CodeBlock cb = new CodeBlock();

        ArrayList<Node> node = new ArrayList<Node>();
        PlainText text = new PlainText();
        text.setContent("hi");
        cb.addToken(text);

        node.add(dummy);
        node.add(cb);
        h.setNodelist(node);
        h.setSequence(0);
        h.setTempNode();
        h.visit(cb);
        h.setSequence(1);
        h.setTempNode();
        h.visit(cb);
        assertEquals("<pre><code>hi</pre></code>",h.getLine());


    }
    @Test
    public void testCodeBlock2() {
        HTMLVisitor h = new HTMLVisitor();
        Text dummy = new Text();
        CodeBlock cb = new CodeBlock();

        ArrayList<Node> node = new ArrayList<Node>();
        PlainText text = new PlainText();
        text.setContent("");


        node.add(dummy);
        node.add(cb);
        h.setNodelist(node);
        h.setSequence(0);
        h.setTempNode();
        h.visit(cb);
        h.setSequence(1);
        h.setTempNode();
        h.visit(cb);
        assertEquals("<pre><code></pre></code>",h.getLine());


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
        assertEquals("<blockquote>hi</blockquote>",h.getLine());
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
        assertEquals("<blockquote></blockquote>",h.getLine());

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
