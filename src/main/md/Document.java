package md;
import java.util.ArrayList;
import java.util.Iterator;


public class Document implements MDElement{

	ArrayList<String> document = new ArrayList<String>();
	Font font = new Font();
   	Header header = new Header();
    ItemList ilist = new ItemList();
    OrderedList olist = new OrderedList();
    HorizontalRule HR = new HorizontalRule();
	LineFeed LF = new LineFeed();
    ////Yoojin
    BlockQuotes bq = new BlockQuotes();
	CodeBlock cb=new CodeBlock();
	Text text = new Text();

    public Document() {

    }
    public void accept(MDElementVisitor v){
    	//header.accept(v);
    	font.accept(v);
    	LF.accept(v);
    	HR.accept(v);
    	ilist.accept(v);
    	olist.accept(v);
    	bq.accept(v);
    	cb.accept(v);
    	text.accept(v);

		v.visit(this);

    }

   /*
    public ArrayList<String> getDocuments(){
    	hi = new ArrayList<String>();
    	return hi;

    }
    */

    public void addDocument(String line){
    	document.add(line);
    	//checkSyntax(line);
    }

    public ArrayList<String> getDocument(){
    	return document;
    }


}
