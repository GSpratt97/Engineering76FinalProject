# Engineering 76
## Web development testing

## Background

A web testing framework to enable automation testing on the trainee tracker website. The website was hosted locally using the trainee tracker project built in Java by Engineering 72.

## Structure 

The framework was built following the Page Object Model (POM) design pattern to enable effective test automation by creating an object repository for the web UI elements. The POM enables a reduction in code duplication and also improves the readability and test maintenance of the project.

Each page has its own Java class. Each class contains methods to cover all the current functionality on each page of the current website.

Here is a diagram to show the POM structure:

![](src/test/resources/images/Page.png)

## Aim

To test the sparta trainee tracker website using Selenium and Cucumber/Gherkin syntax.
