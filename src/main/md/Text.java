package md;
public class Text extends Node{
	public Text (){
		notice = "Text";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
