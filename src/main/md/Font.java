package md;
public class Font extends Node{

	public String[][] syntax ={{"h1","#"},{"h2","##"},{"h3","###"},
			   {"h4","####"},{"h5","#####"},{"h6","######"},
			   {"",""}};

	public Font(){
		notice = "Font";
	}

	public void accept(MDElementVisitor v) {
		v.visit(this);
	}

	//yoojin



}
