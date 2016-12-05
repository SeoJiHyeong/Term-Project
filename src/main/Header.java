import java.util.Iterator;

public class Header extends Node {
	public String[][] syntax ={{"h1","#"},{"h2","##"},{"h3","###"},
					   {"h4","####"},{"h5","#####"},{"h6","######"},
					   {"",""}};
	
	public Header(){
		notice = "Header";
	}
//	String[] content;
	public void accept(MDElementVisitor v) {
		v.visit(this);
	}
}
	
