set ProjectPath=C:\training2016\november-class\workspace\TestAutomation_week13\TestAutomation
cd %ProjectPath%
set classpath=C:\training2016\november-class\workspace\TestAutomation_week13\TestAutomation\src\test\resources;%ProjectPath%\lib\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause