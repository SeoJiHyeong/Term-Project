package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class converter {
	static String input = "";
	static String output= "";
	static String option= "";
	public static void main(String args[]){
		if(!check_argument(args)) return;
		System.out.println("next step");
	}
	public static boolean check_argument(String[] args){
		if(args.length==0){
			help_message();
			return true;
		}
		else if(args.length==1){
			if(args[0].equals("-h") || args[0].equals("--help")){
				help_message();
				return true;
			}
			else if(check_md(args[0]) && check_file_exist(args[0])){
					input = args[0];
					System.out.println("ready");
					return true;
			}
			else{
				System.out.println("File is not exist or not markdown(.md) File or not invalid");
				return false;
			}
		}
		else if(args.length==2){
			if((check_option(args[0]) || check_option(args[1])) && (check_md(args[0]) || check_md(args[1]))){
				if((check_md(args[0]) && check_file_exist(args[0]))||(check_md(args[1]) && check_file_exist(args[1]))){
					System.out.println(args[0]+" "+args[1]);
					if(check_option(args[0])){
						option = args[0];
						input = args[1];
					}
					else{
						option = args[1];
						input = args[0];
					}
					return true;
				}
				else{
					System.out.println("File is not exist or not markdown(.md) File");
					return false;
				}
			}
			else{
				System.out.println("Invalid option or File is not available");
				return false;
			}
			
		}
		else if (args.length==3){
			if((args[0].equals("-o")&&check_md(args[2])&&check_file_exist(args[2]))||(check_md(args[0])&&check_file_exist(args[0])&&args[1].equals("-o"))){
				if(check_md(args[2])){
					output = args[1];
					input = args[2];
				}
				else if(check_md(args[0])){
					input = args[0];
					output = args[2];
				}
				System.out.println(args[0]+" "+args[1]+" "+args[2]);
				return true;
			}
			else{
				System.out.println("Invalid option or File is not available");
				return false;
			}
		}
		else if (args.length==4){
			if((args[0].equals("-o")&&(check_md(args[2])&&check_file_exist(args[2])&&check_option(args[3]))||(check_md(args[3])&&check_file_exist(args[3])&&check_option(args[2])))||
			   (args[1].equals("-o")&&(check_md(args[0])&&check_file_exist(args[0])&&check_option(args[3]))||(check_md(args[3])&&check_file_exist(args[3])&&check_option(args[0])))||
			   (args[2].equals("-o")&&(check_md(args[0])&&check_file_exist(args[0])&&check_option(args[1]))||(check_md(args[1])&&check_file_exist(args[1])&&check_option(args[0])))){
				if(args[0].equals("-o") && check_md(args[2])){
					input = args[2];
					output = args[1];
					option = args[3];
				}
				else if(args[0].equals("-o") && check_md(args[3])){
					input = args[3];
					output = args[1];
					option = args[2];
				}
				else if(args[1].equals("-o") && check_md(args[0])){
					input = args[0];
					output = args[2];
					option = args[3];
				}
				else if(args[1].equals("-o") && check_md(args[3])){
					input = args[3];
					output = args[2];
					option = args[0];
				}
				else if(args[2].equals("-o") && check_md(args[0])){
					input = args[0];
					output = args[3];
					option = args[1];
				}
				else if(args[2].equals("-o") && check_md(args[1])){
					input = args[1];
					output = args[3];
					option = args[0];
				}
				System.out.println(option+" "+input+" -o "+output);
				return true;
			}
			else{
				System.out.println("Invalid options or File is not available");
				return false;
			}
		}
		else{
			System.out.println("Invalid options or File is not available");
			return false;
			
		}
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
