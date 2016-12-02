
public class ItemList extends Node{
	public ItemList (){
		notice = "ItemList";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
	
}
