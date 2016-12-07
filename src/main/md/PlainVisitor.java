package md;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainVisitor implements MDElementVisitor{

	String line, target;
 	private ArrayList<Document> documentList = new ArrayList<Document>();
 	private ArrayList <Node>temp = new ArrayList<Node>();
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	//private ArrayList multipleLineCase = new ArrayList();
	//private ArrayList nodeSyntax = new ArrayList();


	int pass=0;

	public void visit(Document d){
		d.addDocument(line);
	}


	//yoojin add
	public void visit(Token t){
		int i;
		//line = node;
		Node temp = nodeList.get(nodeList.size()-1);
		tokenize(temp.getLine(), temp);
	}

	public void addNode(){
		Header test = new Header();
		nodeList.add(test);
		}



	public void visit(Header n){

		System.out.println("header visited");

		String forToken = "";
		int count=0;
		int position = 0;
		Node temp = nodeList.get(nodeList.size()-1);
		for(int i=0;i<line.length();i++) {
			char a=line.charAt(i);
			if(i<6 && a=='#' && count==i)
				count++;
			else {
				position=i;
				break;
			}
		}
		if(count!=0 && line.charAt(position)==32){
			Header node = new Header();
			node.htype=count;
			forToken=line.substring(position+1);
			tokenize(forToken,node);

			nodeList.add(node);
			pass=1;
		}
		//make a case that 2 lines header
		else if(temp.notifyNode().equals("Text")&&(line.charAt(0)==45||line.charAt(0)==61)){
			boolean isHeader = true;
			for(int i=1;i<line.length();i++){
				if((line.charAt(i)==line.charAt(i-1))||line.charAt(i)==32);
				else {
					isHeader = false;
					break;
				}
			}

			if(isHeader){
					Header node = new Header();
					node.htype=1;
					//i don't know
					forToken=line.substring(position+1);
					//i don't know
					tokenize(forToken,node);
					//have to add previus node's plain text and h1
					nodeList.remove(nodeList.size()-1);				//remove and add
					nodeList.add(node);
					pass=1;
					System.out.println("header : "+pass);
			}
			else;
		}
	}

	public void visit(ItemList n){
		System.out.println("itemlist visited");
		char a,b;
		if(line.length()>2){ //add a condition for comparing two letters.
			a = line.charAt(0);
			b = line.charAt(1);
			if(pass==0) {
				if((a==42||a==43||a==45)&&b==32){ //remove the case which is called when previous node is list
						Node temp = nodeList.get(nodeList.size()-1);
						ItemList node = new ItemList();
						node.addContent(line);
						tokenize(line.substring(2,line.length()), node);
						nodeList.add(node);
						pass=1;
						System.out.println("itemlist : "+pass);
				}
				else ;
			}
		}
	}

	public void visit(OrderedList n){
		System.out.println("orderedlist visited");
		int i;
		if(line.length()>2){	//add a condition for comparing two letters.
			for(i=0;i<line.length();i++){
				if(line.charAt(i)>=48&&line.charAt(i)<=57){
					if(line.charAt(i+1)==46){
						Node temp = nodeList.get(nodeList.size()-1);
						if(temp.notifyNode().equals("OrderedList")){
							OrderedList node = new OrderedList();    //Originally, it add content at this case,
							node.addContent(line);                   //but now it compare the number of previous
							node.setNumber(temp.number+1);	 //one and add new node and count the number
							tokenize(line.substring(2,line.length()), node);
							nodeList.add(node);
							pass=1;
							System.out.println("orderedlist : "+pass);
							break;
						}
						else{
							OrderedList node = new OrderedList();
							node.addContent(line);
							node.setNumber(1);
							tokenize(line.substring(2,line.length()), node);
							nodeList.add(node);
							pass=1;
							System.out.println("orderedlist : "+pass);
							break;
						}
					}
					else ;
				}
				else break;
			}
		}
	}

	public void visit(HorizontalRule n){
		System.out.println("horizontalRule visited");
		int i;
		int ruleCase = 0;
		if(pass==0){
			for(i=0;i<line.length();i++){
				if(!(line.charAt(i)==32||line.charAt(i)==45||line.charAt(i)==42))break;
				else{
					switch(ruleCase){
					case 0:
						if(line.charAt(i)==32||line.charAt(i)==45||line.charAt(i)==42){
							if(line.charAt(i)==42)ruleCase = 1;
							else if(line.charAt(i)==45)ruleCase = 2;
							else ruleCase = 0;
						}
						else ruleCase =3;
						break;
					case 1:
						if(line.charAt(i)==32||line.charAt(i)==42)ruleCase = 1;
						else ruleCase = 3;
						break;
					case 2:
						if(line.charAt(i)==32||line.charAt(i)==45)ruleCase = 2;
						else ruleCase = 3;
						break;
					default: ruleCase = 3;
					break;
					}
				}

				if(ruleCase==3)break;
				else if(i==line.length()-1){
					HorizontalRule node = new HorizontalRule();
					node.addContent(line);
					nodeList.add(node);
					pass=1;
					System.out.println("hr : "+pass);
					System.out.println("horizontalRule");
				}
			}
		}
		else;
	}

	public void setLine(String s){
		line = s;
	}
	public String getLine(){
		return line;
	}
	



	//////////////Yoojin's Part!!
	public void tokenize(String s, Node n){
		String buffer="";

		int aTotal = 0; // ***
		int emCheck=0; // emphasis check
		int stCheck=0; // strong check

		int uTotal = 0; // _
		int uemCheck=0; // _ em
		int ustCheck=0; // __ strong

		int hCheck=0; // header
		int position = 0;
		//System.out.println("a : "+a);

		    for(int i=0;i<s.length();i++){
		        char a = s.charAt(i);
		         if(a =='h')
		         {
		            System.out.println("hhhhhhh");
		            String input_pattern = ".*http://.+";//pattern
		            String input_string = s;

		            Pattern pattern = Pattern.compile(input_pattern);
		            Matcher matcher =  pattern.matcher(s);

		            if (matcher.matches())
		            {
		               System.out.println("match");
		               a = '<';
		            }
		         }
		         //System.out.println("a : "+a);
		         switch(a) {
		         //daeun
		         case '!' :
		            if(buffer != null && !buffer.isEmpty())
		            {
		               PlainText pt = new PlainText();
		               pt.content = buffer;
		               System.out.println("buffer: "+buffer);
		               n.addToken(pt);
		               buffer="";
		         //      buffer+=a;

		               String input_pattern1 = ".*(\\!\\[)(.+)(\\]\\()(.+)\\).*";//pattern
		               //String input_pattern2 = ".*".+".*""
		               String input_string = s;
		               System.out.println("In image "+ s);

		               Pattern pattern = Pattern.compile(input_pattern1);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){
		                  System.out.println("true");

		                  StyleText st1 = new StyleText("image");
		                  st1.setContent(matcher.group(4));
		                  StyleText st2 = new StyleText("/image");
		                  st2.setContent(matcher.group(2));
		                  n.addToken(st1);
		                  n.addToken(st2);
		                  buffer="";

		                  i = matcher.end(4);
		               }
		               else {
		                  System.out.println("false");
		               }

		            }
		            else
		            {
		               /*if*/
		               String input_pattern = ".*(\\!\\[)(.+)(\\]\\()(.+)\\).*";//pattern
		               String input_string = s;
		               System.out.println("In image: "+ s);

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){
		                  System.out.println("true");

		                  StyleText st1 = new StyleText("image");
		                  st1.setContent(matcher.group(4));
		                  StyleText st2 = new StyleText("/image");
		                  st2.setContent(matcher.group(2));              //if there is no alt text, show address instead of alt text
		                  n.addToken(st1);
		                  n.addToken(st2);

		                  buffer="";

		                  i = matcher.end(4);

		            }
		         }
		         break;
		         //1) click : [](http://www.naver.com)
		         case '[' :
		            if(buffer != null && !buffer.isEmpty())
		            {
		               PlainText pt = new PlainText();
		               pt.content = buffer;
		               System.out.println("buffer: "+buffer);
		               n.addToken(pt);
		               buffer="";
		         //      buffer+=a;

		               String input_pattern = ".*(\\[)(.+)(\\]\\()(http:\\/\\/.+)\\).*";//pattern
		               String input_string = s;
		               System.out.println("In image "+ s);

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){
		                  System.out.println("true");
		                  StyleText st1 = new StyleText("link");
		                  st1.setContent(matcher.group(4));
		                  StyleText st2 = new StyleText("/link");
		                  st2.setContent(matcher.group(2));
		                  n.addToken(st1);
		                  n.addToken(st2);
		                  buffer="";

		                  i = matcher.end(4);
		               }
		               else {
		                  System.out.println("false");
		               }

		            }
		            else
		            {

		               String input_pattern = ".*(\\[)(.+)(\\]\\()(http:\\/\\/.+)\\).*";//pattern
		               String input_string = s;
		               System.out.println("In image "+ s);

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){

						  StyleText st1 = new StyleText("link");
		                  st1.setContent(matcher.group(4));
		                  StyleText st2 = new StyleText("/link");
		                  st2.setContent(matcher.group(2));
		                  n.addToken(st1);
		                  n.addToken(st2);

		                  buffer="";

		                  i = matcher.end(4);
		            }
		         }
		         break;


		         //2) <http://www.naver.com>
		         case '<' :
		            if(buffer != null && !buffer.isEmpty())
		            {
		               PlainText pt = new PlainText();
		               pt.content = buffer;
		               System.out.println("buffer: "+buffer);
		               n.addToken(pt);
		               buffer="";

		               String input_pattern = ".*(\\<)(http:\\/\\/.+)(\\>).*";//pattern
		               String input_string = s;
		               System.out.println("In image "+ s);

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){
		                  System.out.println("true");

					 	  StyleText st1 = new StyleText("link");
		                  st1.setContent(matcher.group(2));
		                  StyleText st2 = new StyleText("/link");
		                  st2.setContent(matcher.group(2));
		                  n.addToken(st1);
		                  n.addToken(st2);

		                  buffer="";

		                  i = matcher.end(3);
		               }
		               else {
		                  System.out.println("false");
		               }

		            }
		            else
		            {

		               String input_pattern = ".*(\\<)(http:\\/\\/.+)(\\>).*";//pattern
		               String input_string = s;

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){
		                  System.out.println("true");

					 	  StyleText st1 = new StyleText("link");
		                  st1.setContent(matcher.group(2));
		                  StyleText st2 = new StyleText("/link");
		                  st2.setContent(matcher.group(2));
		                  n.addToken(st1);
		                  n.addToken(st2);
		                  buffer="";

		                  i = matcher.end(3);

		            }
		         }
         break;
			case '=' :
				break;

			case '_' :

				//buffer+=a;
				if(uTotal==1) {
					buffer+=a;
					break;
				}
				if(ustCheck==1){
					if(i+1<s.length()&&s.charAt(i+1)=='_'){
						StyleText st = new StyleText("strong");
						st.content="__";
						n.addToken(st);

						PlainText pt = new PlainText();
						pt.content=buffer.substring(2, buffer.length());
						n.addToken(pt);


						StyleText st2 = new StyleText("/strong");
						n.addContent("__");
						n.addToken(st2);
						buffer="";
						ustCheck=0;
						i=i+1;
						break;
					}//** hihi **
					else {
						PlainText pt = new PlainText();
						pt.content="_";
						n.addToken(pt);

						StyleText st = new StyleText("em");
						st.content="_";
						n.addToken(st);

						PlainText pt1 = new PlainText();
						pt1.content=buffer.substring(2, buffer.length());
						n.addToken(pt1);


						StyleText st2 = new StyleText("/em");
						n.addContent("_");
						n.addToken(st2);
						buffer="";
						ustCheck=0;
						uemCheck=0;
						break;
					}//**hi*h
				}
				if(uemCheck==1) {
					StyleText st = new StyleText("em");
					st.content="_";
					n.addToken(st);

					PlainText pt = new PlainText();
					pt.content=buffer.substring(1, buffer.length());
					n.addToken(pt);


					StyleText st2 = new StyleText("/em");
					n.addContent("_");
					n.addToken(st2);
					buffer="";
					uemCheck=0;
					break;
				}// *hihi*


				if(i+2<s.length() && s.charAt(i+1)=='_'&&s.charAt(i+2)=='_') {
					uTotal=1;
					buffer+=a;
					break;
				}
				else if(i+1<s.length() && s.charAt(i+1)=='_'){
					ustCheck=1;
					if(buffer != null && !buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;
						//System.out.println(buffer);
						n.addToken(pt);
						buffer="";
						//buffer+=a;
					}
					buffer="__";
					i=i+1;
					break;
				}

				else {
					uemCheck=1;
					if(buffer != null && !buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;
						//System.out.println(buffer);
						n.addToken(pt);
						buffer="";
						buffer+=a;
					}
					else
						buffer+=a;
				}
				break;


			case '*' :

				//buffer+=a;
				if(aTotal==1) {
					buffer+=a;
					break;
				}
				if(stCheck==1){
					if(i+1<s.length()&&s.charAt(i+1)=='*'){
						StyleText st = new StyleText("strong");
						st.content="**";
						n.addToken(st);

						PlainText pt = new PlainText();
						pt.content=buffer.substring(2, buffer.length());
						n.addToken(pt);


						StyleText st2 = new StyleText("/strong");
						n.addContent("**");
						n.addToken(st2);
						buffer="";
						stCheck=0;
						i=i+1;
						break;
					}//** hihi **
					else {
						PlainText pt = new PlainText();
						pt.content="*";
						n.addToken(pt);

						StyleText st = new StyleText("em");
						st.content="*";
						n.addToken(st);

						PlainText pt1 = new PlainText();
						pt1.content=buffer.substring(2, buffer.length());
						n.addToken(pt1);


						StyleText st2 = new StyleText("/em");
						n.addContent("*");
						n.addToken(st2);
						buffer="";
						stCheck=0;
						emCheck=0;
						break;
					}//**hi*h
				}

				if(emCheck==1) {
					StyleText st = new StyleText("em");
					st.content="*";
					n.addToken(st);

					PlainText pt = new PlainText();
					//System.out.println(buffer.substring(1, buffer.length()));
					pt.content=buffer.substring(1, buffer.length());
					n.addToken(pt);


					StyleText st2 = new StyleText("/em");
					n.addContent("*");
					n.addToken(st2);
					buffer="";
					emCheck=0;
					break;
				}// *hihi*


				if(i+2<s.length() && s.charAt(i+1)=='*'&&s.charAt(i+2)=='*') {
					aTotal=1;
					buffer+=a;
					break;
				}
				else if(i+1<s.length() && s.charAt(i+1)=='*'){
					stCheck=1;
					if(buffer != null && !buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;
						//System.out.println(buffer);
						n.addToken(pt);
						buffer="";
						//buffer+=a;
					}
					buffer="**";
					i=i+1;
					break;
				}

				else {
					emCheck=1;
					if(buffer != null && !buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;
						//System.out.println(buffer);
						n.addToken(pt);
						buffer="";
						buffer+=a;
					}
					else
						buffer+=a;
				}
				break;
			default :
				buffer+=a;
				break;
			}
		}
		if(buffer != null && !buffer.isEmpty()) {
					PlainText pt = new PlainText();
					pt.content=buffer;
					//System.out.println(buffer);
					n.addToken(pt);
					buffer="";
		}

		for(int i=0; i<n.getTokenListSize();i++) {
			System.out.println(n.getTokenList().get(i).notifyToken()+" : "+n.getTokenList().get(i).getContent());
		}

	}


	@Override
	public void visit(BlockQuotes v) {
		// TODO Auto-generated method stub
		System.out.println("blockquotes visited");
		char a = line.charAt(0);
		Node temp = nodeList.get(nodeList.size()-1);
		String forToken;

		if(a==62) {
			System.out.println("BlockQuotes!!!");
			BlockQuotes node = new BlockQuotes();
			node.addContent(line);
			forToken = line.substring(1);
			tokenize(forToken,node);
			nodeList.add(node);
			pass=1;
			System.out.println("bq : "+pass);
			System.out.println("BlockQuotes Done!!!");
		}

		else if(temp.notifyNode().equals("BlockQuotes")) {
			BlockQuotes node = new BlockQuotes();
			tokenize(line,node);
			node.addContent(line);
			pass=1;
			System.out.println("bq : "+pass);
		}

	}

	@Override
	public void visit(CodeBlock v) {
		// TODO Auto-generated method stub
		System.out.println("CodeBlock visited");
		char a=line.charAt(0);
		String forToken;

		//tab case
		if(a==9){
			CodeBlock node = new CodeBlock();
			node.addContent(line);
			forToken=line.substring(1);
			tokenize(forToken,node);
			nodeList.add(node);
			pass=1;
			System.out.println("cb : "+pass);
			System.out.println("CodeBlockkkkk!!");
		}

		//4 spaces case
		else if(a==32) {
			int flag =1;
			int position=0;

			for(int i=0;i<line.length();i++) {
				char b=line.charAt(i);
				if(i<4 && b!=32){
					flag=0;
					break;
				}
				else if(b!=32){
					position=i;
					break;
				}
			}
			if(flag==1) {
				CodeBlock node = new CodeBlock();
				node.addContent(line);
				forToken=line.substring(position);
				tokenize(forToken,node);
				//System.out.println(forToken);
				nodeList.add(node);
				pass=1;
				System.out.println("cb : "+pass);
				System.out.println("CodeBlockkkkk!!");

			}
		}
	}

	@Override
	public void visit(Text v) {
		// TODO Auto-generated method stub
		//System.out.println(pass);
		System.out.println("Text Visitied");
		if(pass==0){
			Text node = new Text();
			tokenize(line,node);
			node.addContent(line);
			nodeList.add(node);
		}
		else
			pass=0;
	}

	public ArrayList<Node> getNode(){
			return nodeList;
	}


}
