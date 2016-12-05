interface MDElementVisitor {
 void visit(Document v);
 void visit(Header v);
 void visit(ItemList v);
 void visit(OrderedList v);
 void visit(HorizontalRule v);
 void visit(Link v);
 void visit(Block v);
  void visit(Emphasis v);
  void visit(QuotedBlock v);
  void visit(Code v);
 void visit(Image v);
 void visit(Token v);
}
