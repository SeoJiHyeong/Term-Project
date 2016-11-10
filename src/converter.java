package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class converter {
	static String input = "";
	static String output= "";
	static String option= "";
	static List list_file = new ArrayList();
	static List list_options = new ArrayList();
	public static void main(String args[]){
		if(!check_argument(args)) return;
		System.out.println("==============");
		System.out.println("SUCCESS");
		System.out.println("==============");
	}
	
	public static boolean check_argument(String[] args){
		if(args.length==0){
			help_message();
			return true;
		}
		else{
			if(check_grammar(args)) return true;
		}
		
		return false;
	}
	public static boolean check_grammar(String[] args){
		boolean isOutputOptions = false;
		int indexOutputOptions = -1;
		int[] check_index = new int[args.length];
		
		for(int i = 0 ; i < args.length ; i ++){
			check_index[i]=0;
		}
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("-o")){
				indexOutputOptions = i;
				check_index[i]=1;
				isOutputOptions = true;
				break;
			}
		}
		if(isOutputOptions){
			for(int i = 0 ; i < args.length; i++){
				if(check_index[i]==0 && (check_option(args[i]) && i==indexOutputOptions+1 || check_md(args[i]) && i==indexOutputOptions+1 || indexOutputOptions==args.length-1) || args.length==1){
					System.out.println("Output should be next to -o option");
					return false;
				}
			}
			output = args[indexOutputOptions+1];
			check_index[indexOutputOptions+1]=1;
			System.out.println(args[indexOutputOptions] +" " +args[indexOutputOptions+1]);
		}
		for(int i = 0; i < args.length;i++){
			if(check_index[i]==0&&args[i].substring(0, 1).equals("-") &&!check_option(args[i])){
				System.out.println("Invalid Options");
				return false;
			}
			else if(check_index[i]==0 && args[i].substring(0, 1).equals("-")){
				list_options.add(args[i]);
				check_index[i]=1;
				System.out.println("Options : " + args[i]);
			}
		}
		for(int i = 0 ; i < args.length;i++){
			if(check_index[i]==0 && check_file(args[i])){
				list_file.add(args[i]);
				System.out.println("File : " + args[i]);
			}
			else if(check_index[i]==0){
				System.out.println("File is not exist or not MarkDown File : " + args[i]);
				return false;
			}
		}
		if(list_file.size()==0){
			System.out.println("Markdown File is should be input");
			return false;
		}
		return true;
		
	}
	public static void help_message(){
		System.out.println("java converter [-options] md_File [-options] output");
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
		if(c.length()>3&&!c.substring(0, 1).equals("-") && c.substring(c.length()-3, c.length()).equals(".md")) return true;
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
