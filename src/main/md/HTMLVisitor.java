package md;
import java.util.ArrayList;

public class HTMLVisitor implements MDElementVisitor {
	String line;

	int nodeIndex;
	int sequence;
	//document
 	private Document ParsedDocument;

 	private ArrayList temp = new ArrayList();
	private Node tempNode;
 	//node
	private ArrayList<Node> nodeList = new ArrayList<Node>();


	//it will save converted htmlcode
	private ArrayList<String> HTMLList = new ArrayList();

	 public void visit(Document d){
		 d.addDocument(line);
		 ParsedDocument = d;
	 }



	 //node     *****************************************don't use n, only use tempNode
	 public void visit(Header n){
		if(tempNode.notifyNode().equals("Header")){
			/*tempNode = nodeList.get(sequence);
			ArrayList<Token> tokenList = tempNode.getTokenList();
			String tmp ="";
			System.out.println(tempNode.htype);
<<<<<<< HEAD
			System.out.println(tokenList.get(0).notice);
			System.out.println(tokenList.get(0).content);*/
=======
			tmp = "<h"+tempNode.htype+">"+tokenList.get(0).content+"</h"+tempNode.htype+">";
			System.out.println(tokenList.get(0).content);
			line = tmp;
>>>>>>> origin/master
		}
		else;


	 }

	 public void visit(ItemList n){
		if(tempNode.notifyNode().equals("ItemList")){

		}
		else;
	 }

	 public void visit(OrderedList n){
		if(tempNode.notifyNode().equals("OrderedList")){

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
<<<<<<< HEAD
		if(tempNode.notifyNode().equals("BlockQuotes")){

=======
		if(n.notifyNode().equals("BlockQuotes")){
			String tmp = "";
			tempNode = nodeList.get(sequence);
			ArrayList<Token> tokenList = tempNode.getTokenList();
			System.out.println(tokenList.get(0).content);
			tmp ="<blockquote>"+tokenList.get(0).content+"</blockquote>";
			line = tmp;
			System.out.println(line);
>>>>>>> origin/master
		}
		else;
	 }

	 public void visit(CodeBlock n){
		if(tempNode.notifyNode().equals("CodeBlock")){

		}
		else;
	 }



	 //token
<<<<<<< HEAD
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
=======
	 /*
	 public void visit(Link t){
>>>>>>> origin/master

	 }

<<<<<<< HEAD
	public void tokenParser(Token t){
		if(t.notifyToken().equals("em")||t.notifyToken().equals("/em")||t.notifyToken().equals("strong")||t.notifyToken().equals("/strong")){
			t.setContent("<"+t.notifyToken()+">");
		}
		//else if(t.notyfyToken.)
	}
=======
	 public void visit(Block t){

	 }

	 public void visit(Emphasis t){

	 }
>>>>>>> origin/master


	 public void visit(Image t){

	 }
	 */
	 public void visit(Token t){

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
