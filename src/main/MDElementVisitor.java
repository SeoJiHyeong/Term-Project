
public interface MDElementVisitor {
	void visit(Header v);
	void visit(ItemList v);
	void visit(OrderedList v);
	
	void visit(HorizontalRule v);
	
	void visit(Token t);
	
	/////Yoojin
	void visit(Text v);
	void visit(BlockQuotes v);
	void visit(CodeBlock v);
}
