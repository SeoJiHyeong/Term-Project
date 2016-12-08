package md;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import org.w3c.tidy.Tidy;

public class converter {
	static String input = "";
	static String output= "result.html";
	static String option= "";
	static int file_count = 0;
	static int option_count = 0;
	static int output_count = 0;
	static List list_file = new ArrayList();
	static List list_options = new ArrayList();
	static List list_output = new ArrayList();


	private static ArrayList<ArrayList<String>> mGroupList = new ArrayList<ArrayList<String>>();;
	private static ArrayList<String> mChildList = null;
	public static void main(String args[]) {

		if(!new_check_grammar(args)) return;
		Document document = new Document();
		PlainVisitor plainvisitor = new PlainVisitor();
		HTMLVisitor htmlvisitor = new HTMLVisitor();
		plainvisitor.addNode();

        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(input));
            while(true) {
                String line = br.readLine();
                if(line==null) break;
				  else if(line.equals(""))
				  {
					 line = "~";
					 plainvisitor.setLine(line);
					 document.accept(plainvisitor);
				  }
				  else{
					 plainvisitor.setLine(line);
					 document.accept(plainvisitor);
				  }
            }
            br.close();


            htmlvisitor.setNodelist(plainvisitor.getNode());


            Document dd = new Document();

            dd.addDocument("<html>");
            for(int i=1;i<htmlvisitor.getNodeIndex();i++){
                htmlvisitor.setLine("");
                htmlvisitor.setSequence(i);
                htmlvisitor.setTempNode();
                dd.accept(htmlvisitor);
            }
            dd.addDocument("</html>");

            ArrayList<String> html = dd.getDocument();
          
            String string  = new String();
                
            for(int i=0;i<html.size();i++){
              
                    string += html.get(i);
            }
               
            jtidy Jtidy = new jtidy();
            Jtidy.check(string);
                
            System.out.println("====================jtidy check ok"); 


            FileWriter fw = new FileWriter(output);

            for(int i=0;i<html.size();i++){
                System.out.println(html.get(i));
                fw.write(html.get(i));
            }
            fw.close();




        }catch(IOException e){
            System.out.println("File not found");
        }





	}


	public static boolean new_check_grammar(String[] args){
		int[] index_md = new int[args.length];
		int[] index_output = new int[args.length];
		int[] index_output_option = new int[args.length];
		int[] index_option = new int[args.length];

		if(args.length==0){
			help_message();
			return true;
		}
		else if(args.length==1 && (args[0].equals("-h")||args[0].equals("--help"))){
			help_message();
			return true;
		}

		for(int i = 0 ; i < args.length; i++){
			index_md[i]=0;
			index_output[i]=0;
			index_output_option[i]=0;
			index_option[i]=0;
		}
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("-o")){
				index_output_option[i]=1;
				if(!check_option(args[i+1])){
					index_output[i+1]=1;
				}
				else{
					System.out.println("output option error");
				}
			}
			else if(check_md(args[i])) {
				index_md[i]=1;

			}
			else if(check_option(args[i])) {
				index_option[i]=1;

			}
		}



		if(!check_file(args[0])) {
            System.out.println(args[0]);
			System.out.println("FILE ERROR");
			return false;
		}
		int x = 0;
		int opt = 1;
		int out = 0;
		int out_f = 0;

		while(true){
			if(x>=args.length){
				break;
			}

				opt=0;
				out=0;
				out_f=0;


			x++;
			if(x<=args.length-1){
				if(check_option(args[x])) {
					opt=1;
					x++;
				}
				if(x < args.length-1 && args[x].equals("-o")){
					x++;
					out = 1;
					if(check_option(args[x]) ){
						System.out.println("Output ERROR");
						return false;
					}
					else{
						x++;
						out_f = 1;
					}
				}
				if(x>=args.length){
					break;
				}
				if(opt==0 && check_option(args[x])){
					opt=1;
					x++;
				}

				else{
					System.out.println("ERROR");
					return false;
				}

			}
			else break;

		}


		int cc = 0;
		int pp = 0;
		for(int i=0; i < args.length;i++){
			if(index_md[i]==1){

					if(cc!=0){
						mGroupList.add(mChildList);
					}

					mChildList = new ArrayList<String>();
					mChildList.add(args[i]);
					cc++;



			}
			else if(index_output_option[i]==1){
				mChildList.add(args[i]);

			}
			else if(index_output[i]==1){
				mChildList.add(args[i]);

			}
		}

		mGroupList.add(mChildList);
		for(int i = 0 ; i < mGroupList.size();i++){
			
			int aa = mGroupList.get(i).size();
			for(int j = 0; j < aa;j++){
				
				if(j==0){
					input = mGroupList.get(i).get(j);
				}
                if(mGroupList.get(i).get(j).equals("-o")){
                    output = mGroupList.get(i).get(j+1);
                }

			}
		
		}
		return true;
	}

	public static void help_message(){
		System.out.println("java converter md_File1 [-options] md_File2 [-options] ...");
		System.out.println("Options : ");
		System.out.println("\t-f\t\tFancy Style");
		System.out.println("\t-s\t\tSlide Style");
		System.out.println("\t-p\t\tPlain Style(Default)");
		System.out.println("\t-o\t\tNaming Output name");
		System.out.println("\t-h(--help)\tHelp");
	}

	public static boolean check_option(String c){
		if(c.equals("-f")||c.equals("-s")||c.equals("-p")) return true;
		return false;
	}
	public static boolean check_file(String c){
		return check_md(c) && check_file_exist(c);
	}
	public static boolean check_md(String c){
		if(c.length()>3&& c.substring(c.length()-3, c.length()).equals(".md")) return true;
		return false;
	}
	public static boolean check_file_exist(String c){
		try{
			FileReader fstream = new FileReader(c);
			return true;

		}catch(FileNotFoundException e){
			return false;
		}

	}
}
