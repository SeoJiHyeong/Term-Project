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

		
	}
	

	
	public void visit(Block n){}
	public void visit(Emphasis n){}
	public void visit(QuotedBlock n){}
	public void visit(Code n){}
	public void visit(Image n){}
	
	public void visit(Link n){ //아직 cover해야할 case 굉장히 많음
		int phase = 0;
		int i;
		for(i=0;i<line.length();i++){
			switch(phase){
			case 0:
				if(line.charAt(i)==91)phase = 1;
				break;
			case 1:
				if(line.charAt(i)==93)phase = 2;
				else if(line.charAt(i)==91)phase = 1;
				else;
				break;
			case 2:
				if(line.charAt(i)==40)phase = 3;
					else if(line.charAt(i)==91)phase = 1;
				else phase = 0;
				break;
			case 3:
				if(line.charAt(i)==41)phase = 4;
				else if(line.charAt(i)==40)phase = 0;
				else if(line.charAt(i)==91)phase = 1;
				else;
				break;
				default:
					break;
			}
			if(phase==4){
				Link node = new Link();
				node.addContent(line);
				nodeList.add(node);
				break;
			}
		}
	}
	
	public void visit(Header n){ //수정해야함 한줄이 그냥 plain이고 다음줄이 --- 나 ====인 부분 cover해야함
		int i;
		for(i=n.syntax.length-1;i>=0;i--){
			target = line.substring(0, n.syntax[i][0].length());
			if(target.equals(n.syntax[i][0])){
				Header node = new Header();
				node.addContent(line);
				nodeList.add(node);
			}
		}
	}
	
	public void visit(ItemList n){
		char a = line.charAt(0);
		char b = line.charAt(1);
		if((a==42||a==43||a==45)&&b==32){
				Node temp = nodeList.get(nodeList.size()-1);
				if(temp.notifyNode().equals("ItemList")){
					temp.addContent(line);
				}
				else{
					ItemList node = new ItemList();
					node.addContent(line);
					nodeList.add(node);
				}
		}
		else ;
	}
	
	public void visit(OrderedList n){
		int i;
		for(i=0;i<line.length();i++){
			if(line.charAt(i)>=48&&line.charAt(i)<=57){
				if(line.charAt(i+1)==46){
					Node temp = nodeList.get(nodeList.size()-1);
					if(temp.notifyNode().equals("OrderedList")){
						temp.addContent(line);
						break;
					}
					else{
						OrderedList node = new OrderedList();
						node.addContent(line);
						nodeList.add(node);
						break;
					}
				}
				else ;
			}
			else break;
		}
	}
	public void visit(HorizontalRule n){
		int i;
		int ruleCase = 0;
		
		for(i=0;i<line.length();i++){
			if(!(line.charAt(i)==32||line.charAt(i)==45||line.charAt(i)==42))break;
			else{
				switch(ruleCase){
				case 0: 
					if(line.charAt(i)==32||line.charAt(i)==45||line.charAt(i)==42){
						if(line.charAt(i)==42)ruleCase = 1;
						else if(line.charAt(i)==45)ruleCase = 2;
						else ruleCase = 0;
					}
					else ruleCase =3;
					break;
				case 1:
					if(line.charAt(i)==32||line.charAt(i)==42)ruleCase = 1;
					else ruleCase = 3;
					break;
				case 2:
					if(line.charAt(i)==32||line.charAt(i)==45)ruleCase = 2;
					else ruleCase = 3;					
					break;
				default: ruleCase = 3;
				break;
				}
			}
			
			if(ruleCase==3)break;
			else if(i==line.length()-1){
				HorizontalRule node = new HorizontalRule();
				node.addContent(line);
				nodeList.add(node);
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
