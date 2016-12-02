
public abstract class Token implements MDElement{
		String content;
	
	  	public void accept(MDElementVisitor visitor) {
	  		visitor.visit(this);
	  	}
}
