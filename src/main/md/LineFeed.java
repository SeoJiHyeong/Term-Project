package md;
public class LineFeed extends Node{
	public LineFeed(){
		notice = "LineFeed";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
