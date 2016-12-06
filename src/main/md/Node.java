package md;
import java.util.ArrayList;

public class Node implements MDElement {
	private ArrayList tokenList = new ArrayList();
 	ArrayList<String> content = new ArrayList();
 	String notice;
 	String line;
 	int htype=0;
    public String[][] syntax;
    
 
    
	public void accept(MDElementVisitor v){
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
	
	
	//////YooJin Add

	
	public int getTokenListSize() {
		return tokenList.size();
	}
	public ArrayList<Token> getTokenList() {
		return tokenList;
	}	
	
}
