import java.util.Scanner;
public class demo{
	public static void main(String[] arg){
		Scanner scanner = new Scanner(System.in);

		Document document = new Document();
		visitor plainvisitor = new visitor();
		plainvisitor.addNode();
		String line;// = "* sdsdsds";

		while(true){
				System.out.println("%%%%%%%");
				line = scanner.nextLine();
				System.out.println("########");
				plainvisitor.setLine(line);
				document.accept(plainvisitor);

				//scanner.nextLine();
				System.out.println("324234234234");
				if(line.equals("exit")) break;
		}
	}


}