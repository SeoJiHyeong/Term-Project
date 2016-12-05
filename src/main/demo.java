import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		Document document = new Document();
		PlainVisitor plainvisitor = new PlainVisitor();
		plainvisitor.addNode();
		String line;

		while(true){
				
				System.out.println("%%%%%%%");
				line = scanner.nextLine();
				System.out.println("########");
				plainvisitor.setLine(line);
				document.accept(plainvisitor);

				//scanner.nextLine();
				//System.out.println("324234234234");
				if(line.equals("exit")) break;
		}
	}

}
