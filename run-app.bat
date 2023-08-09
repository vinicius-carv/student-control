@echo off

:: Build the application
mvn clean package

:: Run the application
java -jar your-application-name.jar

:: Pause to keep the console open
pause