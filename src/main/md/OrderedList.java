package md;
public class OrderedList extends Node{
	public int number;

	public OrderedList(){
		notice = "OrderedList";
		listLevel = 1;
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}

	public void setNumber(int i){
		number = i;
	}
	public int getNumber(){
		return number;
	}
}
