Prerequisites

Java: Make sure you have Java installed on your system.
Eclipse(IDE) - This project was created on Eclipse IDE.
Maven: Install Maven to manage dependencies and build your project.
Cucumber Plugin - Install Cucumber plugin from Eclipse marketspace.

Project Structure:

ebayProject
├── src/main/java
├── src/main/resources
├── src/test/java
│   ├── page_Factory
│   │   └── Page_Elements_Filter_Functionality.java
│   │   └── Page_Elements_Search_Functionality.java
│   ├── stepDefinition
│   │   └── Filter_Functionality.java
│   │   └── Search_Functionality.java
│   │   └── TestRunner.java
├── src/test/resources
│   ├── Features
│   │   └── Scenarios.feature
├── Drivers
│   ├── chromedriver.exe
├── target
│   ├── HTMLReports
│   │   └── report.html
│   ├── JSONReports
│   │   └── report.json
│   ├── JunitReports
│   │   └── report.xml
├── JRE System Library
├── Maven Dependencies.
├── pom.xml



Approach/About the project:

This is Maven Project with different dependencies like Selenium, Junit. Also Cucumber BDD plugin is used for the project. All the dependencies
are maintained in the pom.xml. It used webdriver(chromedriver) for implementation which is already available in the Drivers folder. 

Scenarios.feature file is available under src/test/resources/Features which is written in BDD style and it consist of all the scenarios 
given in the problem statement.

The Step definition files are present under src/test/java/stepDefinition which incorporates the codes for all the steps given in the 
feature file.

I've used Page Factory Model which is an extension of Page Object Model for maintainance of various web elements and their initialization.
The page files are created under src/test/java/page_Factory where all the web elements definitions are stored for the step definition files

A Test Runner class is created for overall orchestration and report generation.

The final reports are created in three formats which are html, xml and json and are available in the target folder.



Execution of the project

After the initial setup, import the project in the IDE and run the TestRunner.java file as Junit Test. After execution, refresh the 
complete project and check for the reports in the target folder.


