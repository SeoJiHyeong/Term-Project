
public class OrderedList extends Node {
	public int number;
	
	public OrderedList(){
		notice = "OrderedList";
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
