# SeleniumWebDriverTest

Simple automation test using Selenium Web Driver and JUnit. Cucumber integration was used to implement the testing in BDD way.

This automation test performs the following requested steps:

```
1. Open page https://www.solaredge.com/contact/qa_automation_test
2. Fill sample data in all fields of the form (for coutry select United States)
3. Submit form and make an "Assert" that form is submitted sucessfully - check
   that Success message is "Successfully submitted"
4. Bonus task:  Add logic for calculated field and insert correct number in it
```
Since the objective of the test was only to check that the message returned is the *Successfully submitted*, proper data were chosen in order for the form to be submitted successfully. The test is build in such a way that it can be easily extended to test a collection of data for the various fields by using the *Examples* feature of Gherkin so the individual fields can be tested. In addition, functions could be added to feed the fields with random data each time a test is run.

The code is well commented to explain each functionality.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To run this project, the following are needed at minumum:

```
Eclipse IDE
```
```
Selenium jar files
```
```
Cucumber jar files
```

### Installing

A step by step series on how to get your development environment running

```
Go to https://www.eclipse.org/downloads/ to doanload Eclipse. Install it afterwards and navigate to
the location of the project folder to open it.
```
```
Go to http://www.seleniumhq.org/download/ and download the necessary Selenium jar files. At minimum:

-Selenium client needs to be downloaded

After downloading, import the libraries to your project's build path.
```
```
Go to  https://mvnrepository.com/ and download the jar files. At minimum the following are required:

-Cobertura code coverage
-Cucumber-core
-Cucumber-java
-Cucumber-junit
-Cucumber-jvm-deps
-Cucumber-reporting
-Hemcrest-core
-Gherkin
-Junit

After downloading, import the libraries to your project's build path.
```

## Running the tests

To run the test case, right-click on the Runner.java file and select Run As->JUnit Test.

Depending on your browser preference, comment-out the necessary lines in the Steps.java file.

## Authors

* **Angelos Ladopoulos**

## Licence

This project is not licenced
