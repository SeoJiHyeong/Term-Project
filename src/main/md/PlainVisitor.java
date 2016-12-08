package md;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainVisitor implements MDElementVisitor{

	String line="";
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

	public void visit(LineFeed n){
		if(pass==0){
			if(line.equals("~")){

				if(nodeList.get(nodeList.size()-1).notifyNode().equals("LineFeed")){
				   pass = 1;
			 	}
			 	else{
                   LineFeed node = new LineFeed();
				   nodeList.add(node);
				   pass = 1;
				}
			 }
			 else ;
		 }
	 }

	public void visit(Header n){



		String forToken = "";
		int count=0;
		int position = 0;
		Node temp = nodeList.get(nodeList.size()-1);
		if(line.length()>0){
			for(int i=0;i<line.length();i++) {
				char a=line.charAt(i);
				if(i<6 && a=='#')
					count++;
				else {
					position=i;
					break;
				}
			}
	      if(count!=0 && line.charAt(position)==32){
         Header node = new Header();
         node.htype=count;
         int j=0;
         for(int i=line.length()-1;i>position;i--) { //test ## hi ##, ## hi ######, ## hi##########
        	if(line.charAt(i)=='#')
        		j++;
        	else
        		break;
         }
         if(j==0)
         {
         forToken=line.substring(position+1);
         }
         else if(line.charAt(line.length()-j-1)==' ')
        	 forToken=line.substring(position+1,line.length()-j-1);
         else
        	 forToken=line.substring(position+1);
         tokenize(forToken,node);

         nodeList.add(node);
         pass=1;
      }
			//make a case that 2 lines header
			else if(temp.notifyNode().equals("Text")&&(line.charAt(0)==45||line.charAt(0)==61)){
				boolean isHeader = true;
				for(int i=1;i<line.length();i++){
					if((line.charAt(i)==line.charAt(i-1)));
					else {
						isHeader = false;
						break;
					}
				}

				if(isHeader){
						Header node = new Header();
						if(line.charAt(0)==61)
						node.htype=1;
						else
						node.htype=2;

						ArrayList<Token> tokenList = temp.getTokenList();
						for(int i=0;i<temp.getTokenListSize();i++){
							node.addToken(tokenList.get(i));
						}
						//have to add previus node's plain text and h1
						nodeList.remove(nodeList.size()-1);				//remove and add
						nodeList.add(node);
						pass=1;

				}
				else;
			}
		}
	}
	public void visit(ItemList n){


		char a,b;
		int startIndex = 0;
		int listLevel = 1;
		if(line.length()>2){ //add a condition for comparing two letters.
			for(int i=0;i+1<line.length();i=i+1){ //count the 'space' before list
				if(line.charAt(i)==32&&line.charAt(i+1)==32){
					startIndex=i+2;
					listLevel++;
					i++;
				}
				else if(line.charAt(i)==32)startIndex++;

				else break;
			}
			if(nodeList.get(nodeList.size()-1).listLevel+3>listLevel){ //only accepts previous level +2 space
				a = line.charAt(startIndex);
				b = line.charAt(startIndex+1);  //parse startindex and startindex+1 and tokenize after them
				if(pass==0) {
					if((a==42||a==43||a==45)&&b==32){ //remove the case which is called when previous node is list
							Node temp = nodeList.get(nodeList.size()-1);
							ItemList node = new ItemList();
							node.addContent(line);
							tokenize(line.substring(startIndex+2,line.length()), node);
							node.listLevel = listLevel;
							nodeList.add(node);
							pass=1;

					}
					else ;
				}
			}

		}

	}

	public void visit(OrderedList n){



		int startIndex = 0;
		int listLevel = 1;

		if(line.length()>2){	//add a condition for comparing two letters.
			for(int i=0;i+1<line.length();i=i+1){ //count the 'space' before list
				if(line.charAt(i)==32&&line.charAt(i+1)==32){
					startIndex=i+2;
					listLevel++;
					i++;
				}
				else if(line.charAt(i)==32)startIndex++;

				else break;
			}
			if(nodeList.get(nodeList.size()-1).listLevel+3>listLevel){
				for(int i=startIndex;i<line.length();i++){
					if(line.charAt(i)>=48&&line.charAt(i)<=57){
						if(line.charAt(i+1)==46&&line.charAt(i+2)==32){
							Node temp = nodeList.get(nodeList.size()-1);
							OrderedList node = new OrderedList();
							node.addContent(line);
							node.listLevel = listLevel;
							tokenize(line.substring(i+3,line.length()), node);
							nodeList.add(node);
							pass=1;

							break;
						}
						else ;
					}
					else break;
				}//'for'
			}//check listLevel
		}

	}
	public void visit(HorizontalRule n){

		int i;
		int ruleCase = 0;
		if(line.length()>0){
			if(pass==0){
				if(line.charAt(0)!= 32)
					for(i=0;i<line.length();i++){
						if(!(line.charAt(i)==32||line.charAt(i)==45||line.charAt(i)==42))break;
						else{
							switch(ruleCase){
							case 0:
                                if(line.charAt(i)==42)ruleCase = 1;
                                else ruleCase = 2;


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

						}
					}
			}
			else;
		}
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


		    for(int i=0;i<s.length();i++){
		        char a = s.charAt(i);
		         switch(a) {
		         case '\\':
		 			if(!buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;

						n.addToken(pt);
						buffer="";
						//buffer+=a;
					}
		        	 if(i+1<s.length()){
		        		 char b=s.charAt(i+1);
		        		 switch(b){
		        		 case '*' :
		        		 case '\\' :
		        		 case '\'' :
		        		 case '_':
		        		 case '{' :
		        		 case '}':
		        		 case '[':
		        		 case ']':
		        		 case '(':
		        		 case ')':
		        		 case '#':
		        		 case '.':
		        		 case '!':
		        			 PlainText pt = new PlainText();
							 pt.content=Character.toString(b);
							 n.addToken(pt);
								buffer="";
								i=i+1;

								break;



		        		 }

		        	 }
		        	 else
		        		 buffer+=a;
                        break;
		         //daeun
                     case '!' :
                         if(!buffer.isEmpty())
                         {


                             PlainText pt = new PlainText();
                             pt.content = buffer;

                             n.addToken(pt);
                             buffer="";

                             String input = ".*(\\!\\[)(.+)(\\]\\()(.+[^\\\"])\\).*";
                             String input1 = ".*(\\!\\[)(.+)(\\]\\()(.+)(\")(.+)(\")\\).*";

                             Pattern pattern = Pattern.compile(input);
                             Matcher matcher = pattern.matcher(s);

                             Pattern pattern1 = Pattern.compile(input1);
                             Matcher matcher1 = pattern1.matcher(s);
                             if(matcher.matches()){

                                 StyleText st1 = new StyleText("image");
                                 st1.setContent(matcher.group(4));
                                 StyleText st2 = new StyleText("/image");
                                 st2.setContent(matcher.group(2));              //if there is no alt text, show address instead of alt text
                                 n.addToken(st1);
                                 n.addToken(st2);
                                 PlainText pt1 = new PlainText();
                                 pt1.setContent("/>");
                                 n.addToken(pt1);
                                 buffer="";
                                 i = matcher.end(4);

                             }
                             else if(matcher1.matches()) {

                                 StyleText st1 = new StyleText("image");
                                 st1.setContent(matcher1.group(4));
                                 StyleText st2 = new StyleText("/image");
                                 st2.setContent(matcher1.group(2));              //if there is no alt text, show address instead of alt text
                                 StyleText st3 = new StyleText("title");
                                 st3.setContent(matcher1.group(6));              //if there is no alt text, show address instead of alt text
                                 n.addToken(st1);
                                 n.addToken(st2);
                                 n.addToken(st3);

                                 buffer="";
                                 i = matcher1.end(7);
                             }
                             else;

                         }
                         else
                         {

                             String input = ".*(\\!\\[)(.+)(\\]\\()(.+[^\\\"])\\).*";
                             String input1 = ".*(\\!\\[)(.+)(\\]\\()(.+)(\")(.+)(\")\\).*";

                             Pattern pattern = Pattern.compile(input);
                             Matcher matcher = pattern.matcher(s);

                             Pattern pattern1 = Pattern.compile(input1);
                             Matcher matcher1 = pattern1.matcher(s);
                             if(matcher.matches()){

                                 StyleText st1 = new StyleText("image");
                                 st1.setContent(matcher.group(4));
                                 StyleText st2 = new StyleText("/image");
                                 st2.setContent(matcher.group(2));              //if there is no alt text, show address instead of alt text
                                 n.addToken(st1);
                                 n.addToken(st2);
                                 PlainText pt1 = new PlainText();
                                 pt1.setContent("/>");
                                 n.addToken(pt1);
                                 buffer="";
                                 i = matcher.end(4);
                             }
                             else if(matcher1.matches()) {

                                 StyleText st1 = new StyleText("image");
                                 st1.setContent(matcher1.group(4));
                                 StyleText st2 = new StyleText("/image");
                                 st2.setContent(matcher1.group(2));              //if there is no alt text, show address instead of alt text
                                 StyleText st3 = new StyleText("title");
                                 st3.setContent(matcher1.group(6));              //if there is no alt text, show address instead of alt text
                                 n.addToken(st1);
                                 n.addToken(st2);
                                 n.addToken(st3);

                                 buffer="";
                                 i = matcher1.end(7);
                             }
                             else
                                 ;
                         }
                         break;
		         //1) click : [](http://www.naver.com)
		         case '[' :
		            if(!buffer.isEmpty())
		            {
		               PlainText pt = new PlainText();
		               pt.content = buffer;

		               n.addToken(pt);
		               buffer="";
		         //      buffer+=a;

		               String input_pattern = ".*(\\[)(.+)(\\]\\()(http:\\/\\/.+)\\).*";//pattern
		               String input_string = s;


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
		               else {
		                  ;
		               }

		            }
		            else
		            {

		               String input_pattern = ".*(\\[)(.+)(\\]\\()(http:\\/\\/.+)\\).*";//pattern
		               String input_string = s;


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
		            if(!buffer.isEmpty())
		            {
		               PlainText pt = new PlainText();
		               pt.content = buffer;

		               n.addToken(pt);
		               buffer="";

		               String input_pattern = ".*(\\<)(http:\\/\\/.+)(\\>).*";//pattern
		               String input_string = s;


		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){


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
		                  ;
		               }

		            }
		            else
		            {

		               String input_pattern = ".*(\\<)(http:\\/\\/.+)(\\>).*";//pattern
		               String input_string = s;

		               Pattern pattern = Pattern.compile(input_pattern);
		               Matcher matcher =  pattern.matcher(s);

		               if(matcher.matches()){


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
					if(!buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;

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
					if(!buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;

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
					if(!buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;

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
					if(!buffer.isEmpty())
					{
						PlainText pt = new PlainText();
						pt.content=buffer;

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
		if(!buffer.isEmpty()) {
					PlainText pt = new PlainText();
					pt.content=buffer;

					n.addToken(pt);
					buffer="";
		}



		if(line.length()>1){
			if(line.charAt(line.length()-2)==32&&line.charAt(line.length()-1)==32){
				StyleText br = new StyleText("br");
				n.addToken(br);
			}
		}
	}


	@Override
	public void visit(BlockQuotes v) {
		// TODO Auto-generated method stub
		char a;

		if(pass==0){
			if(line.length()>0){
				a = line.charAt(0);
				Node temp = nodeList.get(nodeList.size()-1);
				String forToken;

				if(a==62) {

					BlockQuotes node = new BlockQuotes();
					node.addContent(line);
					forToken = line.substring(1);
					tokenize(forToken,node);
					nodeList.add(node);
					pass=1;

				}
			}
		}
	}

	@Override
	public void visit(CodeBlock v) {
		// TODO Auto-generated method stub


		if(pass==0&&line.length()>0){
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
			}

			//4 spaces case
			else if(a==32) {
				int flag=0;

				if(line.length()<=3)
					;
				else {
					for(int i=1;i<4;i++) {
						if(line.charAt(i)!=32)
							break;
						else
							flag+=1;
					}
					if(flag==3) {
						if(line.length()>4){
							CodeBlock node = new CodeBlock();
							node.addContent(line);
							forToken=line.substring(4);
							tokenize(forToken,node);

							nodeList.add(node);
							pass=1;

						}
						else
							;
					}
				}
			}
		}
	}

	@Override
	public void visit(Text v) {
		// TODO Auto-generated method stub
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
