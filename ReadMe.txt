StarNavi Automation Test Task – Bogdan Turchyk

Automation Framework has been created according to "Automation Test Task" document.

General Information
The framework is built with maven - build automation tool which has pom.xml file that allows
me to manage my dependencies/versions easily.
IntelliJ is used as IDE Tool.
Java – Selenium – TestNG are implemented the actual coding logic with inside of the
"Tests" package and it their own respective/related classes.
Page Object Model is used to simplify managing and maintaining the framework.
BasePage (Abstract) is created and initiated with "PageFactory" class using "Driver" and "BasePage" constructor.
"StarNaviTaskPage" is created and extends the "BasePage".
This page keeps the respective webelements and some custom methods in the classes in order to call from Test Classes with the help of page objects,
during the code implementation.
TestBase class (Abstract) is created in order to implement some TestNG annotations such as @BeforeTest, @AfterTest.
"TaskTest" class contains all created tests and extended to the "TestBase" class in order to have reusable codes.
Singleton Design Pattern is used in the "Driver Class" to allow the framework to pass the same instance of the Webdriver in one session.
"BrowserUtils Class" is created in order to have some reusable codes.
"ConfigurationReader Class" is created to read specific data from configuration.properties file.
"configuration.properties" type of file is created in order to keep the important test data about the framework in key-value format.

Test Cases
Note: Those steps below are implemented in the TestBase class with the help of TestNG Annotations (@BeforeTest – @AfterTest)
Navigating to URL: "https://automation-test-starnavi.netlify.app/"

Test Case 1: Verify that field's size in easy dropdown is 5x5 cells
Steps:
1 - Navigate to Home page
2 - Select "Easy" dropdown option
3 - Click "Start" button
4 - Verify that field's size is 5x5 cells

Test Case 2: Verify when user hover over on a cell, then color of this cell is changing (white to blue or blue to wight)
Steps:
1 - Open "Easy" view table
2 - Select certain cell from the table
3 - Verify when user hover over on a cell, then color of this cell is changing (white to blue or blue to wight)

Test Case 3: Verify that selected cells are displayed in "Hover squares" list
Steps:
1 - Open "Easy" view table
2 - Select certain cell from the table
5 - Verify that selected cells are displayed in "Hover squares" list

How To Run The Framework

With The IDE Tool: IntelliJ is recommended
Inside Test Classes:
Open "StarNaviTestTask\src\test\java\io\starNavi\tests\TaskTest" or then
Go to class title and click "Green Play Button" left side of the "Class Name" or
Go to @Test annotation and click "Green Play Button" left side of the "Method Name"

With The Help of IntelliJ Terminal:
Run Specific Test:
Go to Intellij Terminal
Type this command to terminal:
mvn test -Dtest=”TaskTest” 
and hit the "Enter"
It will trigger only specific test class.

Run Specific Test:
mvn test -Dtest=”TaskTest” and hit the "Enter"
It will trigger only specific test class.

Reports
You can navigate to file path: "StarNaviTestTask\target\surefire-reports\emailable-report.hmtl" and open with browser

Bogdan Turchyk – Software Development Engineer in Test
bturchyk@gmail.com
linkedin.com/in/bogdan-turchyk
