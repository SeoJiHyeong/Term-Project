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

	private ArrayList<String> listStack = new ArrayList<String>();

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
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}

			if(tokenList.size()<1)
			tmp = "<h"+tempNode.htype+">"+"</h"+tempNode.htype+">";
			else
			tmp = "<h"+tempNode.htype+">"+line+"</h"+tempNode.htype+">";
			line = tmp;
		}
	 }

	public void visit(Font n){

	}

	 public void visit(ItemList n){
		int previousLevel = nodeList.get(sequence-1).listLevel;
		//int nextLevel = nodeList.get(sequence+1).listLevel;

		if(tempNode.notifyNode().equals("ItemList")){
			line = "<li>";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			line = line + "</li>";

			if(previousLevel==0||previousLevel<tempNode.listLevel
										||listStack.size()==0){
				line = "<ul>\r\n" + line;
				listStack.add("\r\n</ul>");
			}
			else;

			if(sequence==nodeList.size()-1)
				while(listStack.size()!=0){
					line = line + listStack.get(listStack.size()-1);
					listStack.remove(listStack.size()-1);
				}
			else if(nodeList.get(sequence+1).listLevel<tempNode.listLevel)
				for(int i=0;i<tempNode.listLevel-nodeList.get(sequence+1).listLevel;i++){
					if(listStack.size()!=0){
									line = line + listStack.get(listStack.size()-1);
									listStack.remove(listStack.size()-1);
					}
				}
			else;
		}

	 }

	 public void visit(OrderedList n){
		int previousLevel = nodeList.get(sequence-1).listLevel;

		if(tempNode.notifyNode().equals("OrderedList")){
			line = "<li>";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			line = line + "</li>";

			if(previousLevel==0||previousLevel<tempNode.listLevel||listStack.size()==0){
				line = "<ol>\r\n" + line;
				listStack.add("\r\n</ol>");
			}
			else;

			if(sequence==nodeList.size()-1)
				while(listStack.size()!=0){
					line = line + listStack.get(listStack.size()-1);
					listStack.remove(listStack.size()-1);
				}
			else if(nodeList.get(sequence+1).listLevel<tempNode.listLevel)
				for(int i=0;i<tempNode.listLevel-nodeList.get(sequence+1).listLevel;i++){
					if(listStack.size()!=0){
									line = line + listStack.get(listStack.size()-1);
									listStack.remove(listStack.size()-1);
					}
				}
			else;
		}
	 }

	 public void visit(HorizontalRule n){
		if(tempNode.notifyNode().equals("HorizontalRule")){
			line = "<hr>";
		}
	 }

	 public void visit(LineFeed n){
		if(tempNode.notifyNode().equals("LineFeed")){

		}
	 }

	 public void visit(Text n){
		if(tempNode.notifyNode().equals("Text")){
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			if(!(nodeList.get(sequence-1).notifyNode().equals("Text")))
				line = "<p>" + line;

			if(sequence==nodeList.size()-1)
				line = line + "</p>";

				else if(!(nodeList.get(sequence+1).notifyNode().equals("Text")))
					line = line + "</p>";
		}
	 }

	 public void visit(BlockQuotes n){
		if(tempNode.notifyNode().equals("BlockQuotes")){
			String tmp = "";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			if(tokenList.size()>0)
			tmp ="<blockquote>"+line+"</blockquote>";//delete print and add if
			else
			tmp ="<blockquote>"+"</blockquote>";
			line = tmp;
		}
	 }

	 public void visit(CodeBlock n){
		if(tempNode.notifyNode().equals("CodeBlock")){
			String tmp = "";
			ArrayList<Token> tokenList = tempNode.getTokenList();
			for(int i=0;i<tempNode.getTokenListSize();i++){
				visit(tokenList.get(i));
			}
			if(tokenList.size()>0)
			tmp ="<pre><code>"+line+"</pre></code>";//delete print and add if
			else
			tmp ="<pre><code>"+"</pre></code>";
			line = tmp;
		}
	 }



	 //token
	 public void visit(Token t){
			if(t.notifyToken().equals("plaintext")){
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

				if(t.notifyToken().equals("<em>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("</em>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("<strong>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("</strong>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("link"))
					t.setContent("<a href=\"" + t.getContent()+"\"/>");
				else if(t.notifyToken().equals("/link"))
					t.setContent(t.getContent() + "</a>") ;
				else if(t.notifyToken().equals("image"))
					t.setContent("<img src=\"" + t.getContent() +"\"");
				else if(t.notifyToken().equals("title"))
					t.setContent("title=\"" + t.getContent() + "\"/>") ;
				else if(t.notifyToken().equals("/image"))
					t.setContent(" alt=\"" + t.getContent() + "\"") ;
				else if(t.notifyToken().equals("<br>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("<code>"))
					t.setContent(t.notifyToken());
				else if(t.notifyToken().equals("</code>"))
					t.setContent(t.notifyToken());
				else;


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

	public String getLine(){
		return line;
	}
}
