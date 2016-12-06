package md;
import java.util.ArrayList;
import java.util.Iterator;


public class Document implements MDElement{

 	private ArrayList temp = new ArrayList();
	private ArrayList nodes = new ArrayList();

	ArrayList<String> document;

   	Header header = new Header();
    ItemList ilist = new ItemList();
    OrderedList olist = new OrderedList();
    HorizontalRule HR = new HorizontalRule();

    ////Yoojin
    BlockQuotes bq = new BlockQuotes();
	CodeBlock cb=new CodeBlock();
	Text text = new Text();

    public Document() {

    }
    public void accept(MDElementVisitor v){
		v.visit(this);

    	header.accept(v);
    	HR.accept(v);
    	ilist.accept(v);
    	olist.accept(v);
    	bq.accept(v);
    	cb.accept(v);
    	text.accept(v);
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

    public ArrayList getDocument(){
    	return document;
    }


}
