AFEA Automation Framework
Project Structure
Root Files and Folders
pom.xml: Maven configuration file that includes project dependencies, plugins, and configurations.
Configuration.properties: Centralized configuration file containing environment-specific properties like URLs, credentials, and timeouts.
Key Folders
src/test/java/com/project
Contains all Java source files for the automation framework.

pages:

Houses Page Object Model (POM) classes for different application components.
Example:
Cart.java: Represents and manages cart-related functionalities.
LoginPage.java: Manages login page elements and actions.
step_definitions:

Contains Cucumber step definitions that link feature file steps to Java methods.
Example:
Login_Steps.java: Implements login-related steps.
Cart_Steps.java: Implements cart operations.
runner:

Contains the test runner class for executing test cases.
Example:
Cukes.java: Configures Cucumber options (tags, plugins, feature file locations).
utilities:

Contains utility classes for reusability.
Example:
Driver.java: Singleton WebDriver manager.
DriverWait.java: Helper methods for explicit waits.
ConfigurationReader.java: Reads properties from the configuration file.
src/test/resources
Contains all resource files for the framework.

feature:
Holds Cucumber feature files organized into folders.
Example:
folder_0: Contains Login.feature.
folder_1: Contains LaptopCategory.feature, MonitorCategory.feature, PhoneCategory.feature.
target
Contains generated files after running the tests, including:
full-report.html: HTML test report.
How to Run the Framework
Pre-requisites
Install Java (JDK 8 or later).
Install Maven.
Configure environment variables for JAVA_HOME and MAVEN_HOME.
Running Test Cases
Via Command Line:


Via IDE:

Open the project in IntelliJ IDEA or Eclipse.
Run the Cukes.java class as a JUnit test.
Reports
The framework generates an HTML report after test execution.
Location: target/full-report.html.
Open the file in any browser to view detailed test execution results.
How the Plugins Work
html:target/full-report.html:
Generates an HTML report of test execution in the specified location.
Navigate to target/full-report.html.
Open in a browser to review test pass/fail results and error details.
AFEA/
├── .git/
│   ├── config
│   ├── HEAD
│   ├── hooks/
│   ├── info/
│   ├── logs/
│   ├── objects/
│   └── refs/
├── .idea/
│   ├── compiler.xml
│   ├── encodings.xml
│   ├── jarRepositories.xml
│   ├── misc.xml
│   ├── vcs.xml
│   └── workspace.xml
├── Configuration.properties
├── pom.xml
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── project/
│   │   │   │   │   ├── pages/
│   │   │   │   │   │   ├── Cart.java
│   │   │   │   │   │   ├── DashBoardPage.java
│   │   │   │   │   │   └── LoginPage.java
│   │   │   │   │   ├── runner/
│   │   │   │   │   │   └── Cukes.java
│   │   │   │   │   ├── step_definitions/
│   │   │   │   │   │   ├── AddItem_Steps.java
│   │   │   │   │   │   ├── BaseClass.java
│   │   │   │   │   │   ├── Cart_Steps.java
│   │   │   │   │   │   ├── Hookes.java
│   │   │   │   │   │   ├── Login_Steps.java
│   │   │   │   │   │   └── VerifyItems_Steps.java
│   │   │   │   │   ├── utilities/
│   │   │   │   │   │   ├── BrowserSleep.java
│   │   │   │   │   │   ├── ConfigurationReader.java
│   │   │   │   │   │   ├── Driver.java
│   │   │   │   │   │   └── DriverWait.java
│   │   ├── resources/
│   │   │   ├── feature/
│   │   │   │   ├── folder_0/
│   │   │   │   │   └── Login.feature
│   │   │   │   ├── folder_1/
│   │   │   │   │   ├── LaptopCategory.feature
│   │   │   │   │   ├── MonitorCategory.feature
│   │   │   │   │   └── PhoneCategory.feature
│   │   │   │   ├── folder_2/
│   │   │   │   │   ├── AddItems.feature
│   │   │   │   │   └── RemoveItemsFromCart.feature
├── target/
│   ├── full-report.html
│   ├── generated-test-sources/
│   └── test-classes/

