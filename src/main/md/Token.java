package md;
public class Token implements MDElement{
	String content;
	String notice;
	public String notifyToken(){
		return notice;
	}
  	public void accept(MDElementVisitor visitor) {
  		visitor.visit(this);
  	}
  	public String getContent() {
  		return content;
  	}

  	public void setContent(String s){
		content = s;
	}
}
