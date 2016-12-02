import java.util.ArrayList;
import java.util.Iterator;

public abstract class Node implements MDElement {
 	private ArrayList tokenList = new ArrayList();
 	ArrayList<String> content = new ArrayList();
 	String notice;
 	String line;
	//private ArrayList nodes = new ArrayList();
    public String[][] syntax;
/*    ={{"h1","#"},{"h2","##"},{"h3","###"},
            {"h4","####"},{"h5","#####"},{"h6","######"},
            {"",""}};*/
	//public String syntax[][] = {("something" , "gg"),("hi","ddd"),("dd","hello")};
	public void accept(MDElementVisitor v){
			v.visit(this);
	    	Iterator it = tokenList.iterator();
	    	while(it.hasNext()){ 
	    		Token next = (Token)it.next();
	    		next.accept(v);
	    	}
	}
	
	public String notifyNode(){
		return notice;
	}
	
	public void setLine(String s){
		line = s;
	}
	public void addContent(String s){
		content.add(s);
	}
	public String getLine(){
		return line;
	}
	public String getContent(int index){
		return content.get(index);
	}
	public void addToken(Token t){
		tokenList.add(t);
	}
	
}
