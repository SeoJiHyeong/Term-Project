package md;
public class HorizontalRule extends Node{
	public HorizontalRule (){
		notice = "HorizontalRule";
	}
	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
