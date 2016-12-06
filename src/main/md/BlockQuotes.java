package md;
public class BlockQuotes extends Node{
	public BlockQuotes (){
		notice = "BlockQuotes";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
