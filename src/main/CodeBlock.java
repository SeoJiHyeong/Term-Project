
public class CodeBlock extends Node{
	public CodeBlock (){
		notice = "BlockQuotes";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
