cd src
javac -Xlint:unchecked -d ..\build\classes file\exp\FileExplorer.java 
PAUSE 
cd ..\build\classes 
java file.exp.FileExplorer "C:\\SGUS\\CP2\\FileExplorer\\TestFolder"
cls
PAUSE
exit