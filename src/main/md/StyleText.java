package md;

public class StyleText extends Token{
	String content;
	public StyleText(String s){
		switch(s) {
		case "em":
			notice = "<em>";
			break;
		case "/em":
			notice = "</em>";
			break;
		case "strong":
			notice = "<strong>";
			break;
		case "/strong":
			notice = "</strong>";    //add '< >' on all components
			break;
      	case "image":
         	notice = "image";
         	break;
      	case "/image":
         	notice = "/image";
         	break;
      	case "link":
         	notice = "link";
         	break;
      	case "/link":
         	notice = "/link";
         	break;
      	case "br":
         	notice = "<br>";
         	break;
		default:
			notice = s;
			break;
		}
	}


	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
