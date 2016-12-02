import java.util.Iterator;
import java.util.ArrayList;

public class PlainVisitor implements MDElementVisitor {
	String line, target;
 	private ArrayList<Document> documentList = new ArrayList<Document>();
 	private ArrayList temp = new ArrayList();
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	private ArrayList multipleLineCase = new ArrayList();
	private ArrayList nodeSyntax = new ArrayList();
	
	
	public void visit(Token t){
		int i;
		//line = node;
		Node temp = nodeList.get(nodeList.size()-1);
		tokenize(temp.getLine(), temp);
	}
	
	public void visit(StyleText v){
		int i;
	}
	public void visit(PlainText v){
		int i;
	}	
	public void visit(HTMLCode v){
		int i;
	}
	
	
	
	public void visit(Node n){
		int i;
	//	setTarget(line);
		for(i=0;i<n.syntax.length;i++){
			target = line.substring(0, n.syntax[i][0].length());
			if(target.equals(n.syntax[i][0])){
				n.setLine(line);
				n.setContent(target);
				
				nodeList.add(n);
			}
			
			
		}
	}
	//public void visit(list n)
	public void visit(Document v){
		ArrayList document = v.getDocument();

	}
	
	public void setLine(String s){
		line = s;
	}
	public String getLine(){
		return line;
	}
	public void setTarget(String s){
		String temp;
		int i;
		for(i=0;i<s.length();i++){
	//		if(s.charAt(i))				
		}
	}
	
	public void tokenize(String s, Node n){
		
	}
}
