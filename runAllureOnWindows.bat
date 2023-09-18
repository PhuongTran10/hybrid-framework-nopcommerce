set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libExtentV5\*;%ProjectPath%libLog4JVer2\*;%ProjectPath%libSelenium\*;%ProjectPath%libReportNG\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceTest.xml"
allure serve .\allure-json\
pause