import java.util.ArrayList;

public class HTMLVisitor implements MDElementVisitor {
	String line;
	
 	private ArrayList<Document> documentList = new ArrayList<Document>();
 	private ArrayList temp = new ArrayList();
 	
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	private ArrayList nodeSyntax = new ArrayList();
	
	
	private ArrayList<String> HTMLList = new ArrayList();
	
	 public void visit(Document d){
		 
	 }
	 
	 
	 
	 //node
	 public void visit(Header n){
		 
	 }
	 
	 public void visit(ItemList n){
		 
	 }
	 
	 public void visit(OrderedList n){
		 
	 }
	 
	 public void visit(HorizontalRule n){
		 
	 }
	 
	 public void visit(Text n){
		 
	 }
	 
	 public void visit(QuotedBlock n){
		 
	 }
	 
	 public void visit(Code n){
	 
	 }
 
	 
	 //token
	 public void visit(Link t){
		 
	 }
	 public void visit(Block t){
		 
	 }
	 public void visit(Emphasis t){
		 
	 }
	

	 public void visit(Image t){
		 
	 }
	 public void visit(Token t){
		 
	 }

}
