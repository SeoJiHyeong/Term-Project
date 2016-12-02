
public class ItemList extends Node{
	public String[][] syntax ={{"*","asterisk"},{"+","plus"},{"-","hyphen"}};

	@Override
	public void accept(MDElementVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}

}
