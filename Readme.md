# Engineering 76
## Web development testing

## Background

A web testing framework to enable automation testing on the trainee tracker website. The website was hosted locally using the trainee tracker project built in Java by Engineering 72.

## Aim

To test the sparta trainee tracker website using Selenium and Cucumber/Gherkin syntax.

## Structure 

The framework was built following the Page Object Model (POM) design pattern to enable effective test automation by creating an object repository for the web UI elements. The POM enables a reduction in code duplication and also improves the readability and test maintenance of the project.

Each page has its own Java class. Each class contains methods to cover all the current functionality on each page of the current website.

Here is a diagram to show the POM structure:

![](src/test/resources/images/Page.png)

## Using the Framework

Due to the project being based on the POM design pattern the framework is very easy to use for designing tests. Most of the methods are abstracted away from the end user. This enables the tester to write complex tests with little code, greatly improving the readability of the endpoint tests.

The best way to use the framework would be to follow the Behaviour Driven Development (BDD) process in the form of Gherkin syntax. Gherkin syntax tests are extremely readable. This enables much greater collaboration among the developers, QA, non-technical and business participants of the organisation. 

To create a Gherkin statement a .feature file will need to be created in the resources directory (there are already plenty of example files here) following the Given, When, Then 
'step definition' class will need to be created which 
