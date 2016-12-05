
public class StyleText extends Token{
	String content;
	public StyleText(String s){
		switch(s) {
		case "em":
			notice = "em";
			break;
		case "/em":
			notice = "/em";
			break;
		case "strong":
			notice = "strong";
			break;
		case "/strong":
			notice = "/strong";
			break;
		}
	}

	
	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
