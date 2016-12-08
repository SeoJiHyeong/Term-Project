package md;
public class ItemList extends Node{
	public ItemList (){
		notice = "ItemList";
		listLevel = 1;
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
