Usage: md_File1 [-options] [md_File2] [-options]

[Kind of option]
-p: Default mode. Demonstrate the basic format of the file.
-f: Fancy mode. Demonstrate plane mode file in stylish way.
-s: Slide mode. Demonstrate plane mode file in slides using paragraphs.
-o: Give file name of html file which is the output file.
-h: Display this help message (also --help)

[Command line usage]
1. When there is only one md file:
1) If there is no parameter, show help message.
2) When there is one parameter: If ?h is the input, show help message.
   If name of the md file is the input, default mode is executed.
3) When there are two parameters: Open md file. User can choose one of the plain, fancy, slide modes.
   The order of mode option and md file could be changed.
	Example) -f mdfileName / mdfileName -f
		: open mdfile in fancy mode.
4) When there are three parameters, the name of the output file is given. 
	Example) -o outputName mdfileName / mdfileName -o outputName 
		: html ouput file of the md file is the outputName.
5) When there are four parameters, the name of the output file is given when opening the md file. 
	   Example) -o outputName mdfileName -f/ -o outputName -f mdfileName/ -f -o outputName mdfileName/ mdfileName -o outputName -f / -f mdfileName -o outputName/ mdfileName -f -o outputName 
		: open md file in fancy mode, and give outputName of the html output file.
		: Except -o outputName, the order could be changed.

2. When there are more than two md files.
   The options could be given to each md files, and also outputName could be given.
   If there is no certain input of the mode, the plain mode is the default mode. And, name of the output file is given as the same name of the md file.
	 Example) mdfileName1 -p -o outputName1 mdfileName2 -o outputName2 mdfileName3 mdfileName4 -p
		: Open mdfileName1 in plain mode, and the name of the html output file is given as outputName1. Also, the name of the html output file of mdfileName2 is given as outputName2. Open mdifleName3 and mdfileName4 in plain mode.

If not mentioned above or there is no such file, error is occurred.
