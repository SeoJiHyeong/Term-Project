import java.util.ArrayList;

public class HTMLVisitor implements MDElementVisitor {
	String line;
	//document
 	private Document ParsedDocument;

 	private ArrayList temp = new ArrayList();

 	//node
	private ArrayList<Node> nodeList = new ArrayList<Node>();

	//it will save converted htmlcode
	private ArrayList<String> HTMLList = new ArrayList();

	 public void visit(Document d){
		 ParsedDocument = d;
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

	 public void visit(BlockQuotes n){

	 }

	 public void visit(CodeBlock n){

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

}
