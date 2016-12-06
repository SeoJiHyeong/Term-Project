package md;
public class PlainText extends Token{
	public PlainText(){
		notice = "plaintext";
	}
	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
