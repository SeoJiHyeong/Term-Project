package md;

public class StyleText extends Token{
	String content;
	public StyleText(String s){
        if(s.equals("em")){
            notice = "<em>";
        }
        else if(s.equals("/em")){
            notice = "</em>";
        }
        else if(s.equals("strong")){
            notice = "<strong>";
        }
        else if(s.equals("/strong")){
            notice = "</strong>";
        }
        else if(s.equals("image")){
            notice = "image";
        }
        else if(s.equals("/image")){
            notice = "/image";
        }
        else if(s.equals("title")){
            notice = "title";
        }
        else if(s.equals("link")){
            notice = "link";
        }
        else if(s.equals("/link")){
            notice = "/link";
        }
        else if(s.equals("br")){
            notice = "<br>";
        }
        else{
            notice = s;
        }
        
	}


	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
