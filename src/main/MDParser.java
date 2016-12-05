
public class MDParser{
	Document document = new Document();
	public void MDParser(String line){
		
	}
	public void sendLine(String s){
		document.addDocument(s);
	}
	
	public void main(){
		String line ="###hello";	
		sendLine(line);
			
	}
}
