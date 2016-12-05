import java.util.ArrayList;
import java.util.Iterator;


public class Document implements MDElement{
 	private ArrayList document = new ArrayList();
 	private ArrayList temp = new ArrayList();
	private ArrayList nodes = new ArrayList();
	private ArrayList multipleLineCase = new ArrayList();
	private ArrayList nodeSyntax = new ArrayList();
	ArrayList<String> hi;
	
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
    	header.accept(v);
    	HR.accept(v);
    	ilist.accept(v);
    	olist.accept(v);
    	
    	
    	bq.accept(v);
    	cb.accept(v);
    	text.accept(v);
    }
    
    public ArrayList<String> getDocuments(){
    	hi = new ArrayList<String>();
    	return hi;
    	
    }
    
    public void addDocument(String line){
    	document.add(line);
    	//checkSyntax(line);
    }
    public void checkSyntax(String line){
    	Iterator it = multipleLineCase.iterator();
    	Boolean isMultiple = false;
    	String next;
    	while(it.hasNext()){
    		next = (String)it.next();
    		if((line.equals(next))){
    			isMultiple = true;
    			break;
    		}
    	}
    	if(isMultiple==false);
    		//addNode(line);
    }
    public ArrayList getDocument(){
    	return document;
    }
    
    public void addNode(Node n){
    	nodes.add(n);
    }

}
