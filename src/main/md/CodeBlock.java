package md;
public class CodeBlock extends Node{
	public CodeBlock (){
		notice = "CodeBlock";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
