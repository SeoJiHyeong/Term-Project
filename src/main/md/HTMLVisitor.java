package md;
import java.util.ArrayList;

public class HTMLVisitor implements MDElementVisitor {
	String line;

	int nodeIndex;
	int sequence;
	//document
 	private Document ParsedDocument;

 	private ArrayList<Node> temp = new ArrayList<Node>();
	private Node tempNode;
 	//node
	private ArrayList<Node> nodeList = new ArrayList<Node>();


	//it will save converted htmlcode
	private ArrayList<String> HTMLList = new ArrayList<String>();

	 public void visit(Document d){
		 d.addDocument(line);
	 }



	 //node
	 public void visit(Header n){
		if(n.notifyNode().equals("Header")){
			tempNode = nodeList.get(sequence);
			ArrayList<Token> tokenList = tempNode.getTokenList();
			System.out.println(tempNode.notice);
			System.out.println(tempNode.htype);
			System.out.println(tokenList.get(0).notice);
			System.out.println(tokenList.get(0).content);
		}
		else;


	 }

	 public void visit(ItemList n){
		if(n.notifyNode().equals("ItemList")){

		}
		else;
	 }

	 public void visit(OrderedList n){
		if(n.notifyNode().equals("OrderedList")){

		}
		else;
	 }

	 public void visit(HorizontalRule n){
		if(n.notifyNode().equals("HorizontalRule")){

		}
		else;
	 }

	 public void visit(Text n){
		if(n.notifyNode().equals("Text")){

		}
		else;
	 }

	 public void visit(BlockQuotes n){
		if(n.notifyNode().equals("BlockQuotes")){

		}
		else;
	 }

	 public void visit(CodeBlock n){
		if(n.notifyNode().equals("CodeBlock")){

		}
		else;
	 }



	 //token
	 public void visit(Token t){
			 if(t.notifyToken().equals("Plaintext")){
					//good!!
				}
				else{
					tokenParser(t);
				}

	}

	public void tokenParser(Token t){
		if(t.notifyToken().equals("em")||t.notifyToken().equals("/em")||t.notifyToken().equals("strong")||t.notifyToken().equals("/strong")){
			t.setContent("<"+t.getContent()+">");
		}
		//else if(t.notyfyToken.)
	}




	 public void setNodelist(ArrayList<Node> node){
		 nodeList = node;
		 nodeIndex = nodeList.size();
	 }

	 public int getNodeIndex(){
		 return nodeIndex;
	 }

	 public void setLine(String s){
		 line = s;
	 }

	 public void setSequence(int i){
		 sequence = i;
	 }
	 public ArrayList<Node> getNode(){
			return nodeList;
	}
}
