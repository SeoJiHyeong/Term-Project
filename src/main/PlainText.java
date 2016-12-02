
public class PlainText extends Token{
	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
