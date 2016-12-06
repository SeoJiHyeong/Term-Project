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
		 ParsedDocument = d;
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
	 /*
	 public void visit(Link t){

	 }

	 public void visit(Block t){

	 }

	 public void visit(Emphasis t){

	 }


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
}
