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
	 

	
	 public void visit(Token t){
		 
	 }



	@Override
	public void visit(BlockQuotes v) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void visit(CodeBlock v) {
		// TODO Auto-generated method stub
		
	}

}
