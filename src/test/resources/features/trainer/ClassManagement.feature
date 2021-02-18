Feature: Class Management Functionality

  Scenario: Assign a trainee to a class
    Given I am logged in as a trainer and on the Class Management page
    When I select a trainee and a class and then click assign trainee
    Then trainee should be assigned and I should see a success message

  Scenario: Attempting to assign trainee with empty fields
    Given I am logged in as a trainer and on the Class Management page
    When I click assign trainee with empty fields
    Then an error message or prompt should appear and I should stay on the same page



  Scenario: Creating a new class
    Given I am logged in as a trainer and on the Class Management page
    When I fill out the form and click create class
    Then class should be created and I should see a success message

  Scenario: Attempting to create a class with an existing name
    Given I am logged in as a trainer and on the Class Management page
    When I fill out the form, with a pre-exisiting class name and click create class
    Then an error message should appear

  Scenario: Attempting to create a class with empty fields
    Given I am logged in as a trainer and on the Class Management page
    When I click create class with empty fields
    Then an error message or prompt should appear and I should stay on the same page

  Scenario: Attempting to create a class with invalid dates
    Given I am logged in as a trainer and on the Class Management page
    When I fill out the form, with invalid dates and click create class
    Then an error message should appear
