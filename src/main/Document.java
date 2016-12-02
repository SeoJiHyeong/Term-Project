import java.util.Iterator;
import java.util.ArrayList;

class Document implements MDElement{
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
	
    public Document() {

    }
    public void accept(MDElementVisitor v){
    	v.visit(this);
    	
    	ilist.accept(v);
    	olist.accept(v);
    	HR.accept(v);
    	
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