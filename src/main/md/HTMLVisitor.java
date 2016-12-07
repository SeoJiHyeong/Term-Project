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



	 //node     *****************************************don't use 'n', only use 'tempNode'
	 public void visit(Header n){
		if(tempNode.notifyNode().equals("Header")){
			tempNode = nodeList.get(sequence);
			ArrayList<Token> tokenList = tempNode.getTokenList();
			String tmp ="";
			//System.out.println(tempNode.htype);
			tmp = "<h"+tempNode.htype+">"+tokenList.get(0).content+"</h"+tempNode.htype+">";
			System.out.println(tokenList.get(0).content);
			line = tmp;
		}
		else;


	 }

	 public void visit(ItemList n){
		if(tempNode.notifyNode().equals("ItemList")){
			line = "<li>";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			line = line + "</li>";
		}
		else;
	 }

	 public void visit(OrderedList n){
		if(tempNode.notifyNode().equals("OrderedList")){
			if(!(nodeList.get(sequence-1).notifyNode().equals("OrderedList")))
				line = "<ol>";
			else line = "";

			line = line + "<li>";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			line = line + "</li>";

			if(sequence==nodeList.size()-1)
				line = line + "</ol>";
			else if(!(nodeList.get(sequence+1).notifyNode().equals("OrderedList")))
				line = line + "</ol>";
			else;

		}
		else;

	 }

	 public void visit(HorizontalRule n){
		if(tempNode.notifyNode().equals("HorizontalRule")){
			line = "<HR>";
		}
		else;
	 }

	 public void visit(Text n){
		if(tempNode.notifyNode().equals("Text")){
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
		}
		else;
	 }

	 public void visit(BlockQuotes n){
		if(tempNode.notifyNode().equals("BlockQuotes")){
			String tmp = "";
			tempNode = nodeList.get(sequence);
			ArrayList<Token> tokenList = tempNode.getTokenList();
			System.out.println(tokenList.get(0).content);
			tmp ="<blockquote>"+tokenList.get(0).content+"</blockquote>";
			line = tmp;
			System.out.println(line);
		}
		else;
	 }

	 public void visit(CodeBlock n){
		if(tempNode.notifyNode().equals("CodeBlock")){

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

			if(line!=null){
					line = line + t.getContent();
			}
			else line = t.getContent();

	}

	public void tokenParser(Token t){
		switch(t.notifyToken()){
			case "<em>":
			case "</em>":
			case "<strong>":
			case "</strong>":
				t.setContent(t.notifyToken());
				break;

			case "link":
				t.setContent("<a href=\"" + t.getContent()+"\">");
				break;
			case "/link":
				t.setContent(t.getContent() + "</a>") ;
				break;
			case "image":
				t.setContent("<img src=\"" + t.getContent() +"\"");
				break;
			case "/image":
				t.setContent(" alt=\"" + t.getContent() + "\">") ;
				break;
			case "<br>":
				t.setContent(t.notifyToken());
				break;
			default:
				break;
		}/*
		if(t.notifyToken().equals("<em>")||t.notifyToken().equals("</em>")||t.notifyToken().equals("<strong>")||t.notifyToken().equals("</strong>")){
			t.setContent(t.notifyToken());
		}*/
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

	public void setTempNode(){
		tempNode = nodeList.get(sequence);
	}
}
