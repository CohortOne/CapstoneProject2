
cd src
javac -d ..\build\classes gov\sgus\*.java
pause

cd ..\build\classes
java gov.sgus.StarterClass
pause


jar -cvf PackageApp.jar gov\sgus\* 
pause

jar -xvf PackageApp.jar
pause

Echo please add as third line: "Main-Class: gov.sgus.StarterClass"
notepad META-INF\MANIFEST.MF

jar -cvfm PackageApp.jar META-INF\* gov\sgus\*
pause

java -jar PackageApp.jar
pause

