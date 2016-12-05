
public interface MDElementVisitor {
	void visit(Document v);

	void visit(Header v);
	void visit(ItemList v);
	void visit(OrderedList v);
	void visit(HorizontalRule v);
	/////Yoojin
	void visit(Text v);
	void visit(BlockQuotes v);
	void visit(CodeBlock v);

	void visit(Token t);
}
