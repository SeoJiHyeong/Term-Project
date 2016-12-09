## [BUILD]

1. Default build

    Type ‘ant’ in cmd inside directory where build.xml file is located. jar file is created. junit test and jacoco are conducted while creating jar file.   

2. Build Reset.

    ant clean

3. Test (coverage test is not conducted here)

    ant test

4. Coverage Test (Testing is conducted at the same time)

    ant coverage-report




## [DIRECTORY]
	|- bin 

	|- doc

	|- lib

	|- report

	|- src |- main |- md

 	      |- test |- testData

	|- test

	|- build.xml

	|- READ.md

	|- Markdown_converter.jar

bin : built class

doc : javadoc

lib : external library

report : jacoco report

src/main : original java file

src/test : testcase java file

test : testcase classes

testData : test file needed for testing


## [JACOCO]

Coverage information of package can be checked from index.html inside JACOCO file.  


[Kind of option]

-p: Default mode. Demonstrate the basic format of the file.

-f: Fancy mode. Demonstrate plane mode file in stylish way.

-s: Slide mode. Demonstrate plane mode file in slides using paragraphs.

-o: Give file name of html file which is the output file.

-h: Display this help message (also --help)



## [Command line usage]


Usage: java -jar Markdown_converter.jar md_File1 [-options] [md_File2] [-options]


1. When there is only one md file:

	1) If there is no parameter, show help message.

	2) When there is one parameter: If –h is the input, show help message.
           If name of the md file is the input, default mode is executed.
		
		Example) -h

	3) When there are two parameters: Open md file. User can choose one of the plain, fancy, slide modes.
           The order of mode option and md file could be changed.

		Example) mdfileName -f

				: open mdfile in fancy mode.

	4) When there are three parameters, the name of the output file is given. 
		
		Example) mdfileName -o outputName 

				: html ouput file of the md file is the outputName.

	5) When there are four parameters, the name of the output file is given when opening the md file. 

		Example) mdfileName -o outputName -f /mdfileName -f -o outputName 
	
				: open md file in fancy mode, and give outputName of the html output file.
				: Except -o outputName, the order could be changed.


2. When there are more than two md files.

	The options could be given to each md files, and also outputName could be given.
	If there is no certain input of the mode, the plain mode is the default mode. 
	And, name of the output file is given as the same name of the md file.

		 Example) mdfileName1 -p -o outputName1 mdfileName2 -o outputName2 mdfileName3 mdfileName4 -p

				: Open mdfileName1 in plain mode, and the name of the html output file is given as outputName1.
				  Also, the name of the html output file of mdfileName2 is given as outputName2. 
				  Open mdifleName3 and mdfileName4 in plain mode.

If not mentioned above or there is no such file, error is occurred.



