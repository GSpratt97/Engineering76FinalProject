@ManageTrainee
Feature: Creating a trainee profile

  Background: Logged in as a trainer and navigated to Manage Trainee Page.
    Given I am logged in as a Trainer and on the Manage Trainee Page.

  Scenario Template: Creating a trainee with invalid data.
    Given I filled out the Create Trainee form with name "<firstName>" "<lastName>" email "<email>" in "<class>".
    When I click on Create New Trainee on Manage Trainee Page.
    Then I am getting a validation warning for invalid data in Create Trainee form.
    Examples:
      | firstName | lastName | email           | class          |
      | @n3r3!    | Pavel    | good@yahoo.com  | Engineering 76 |
      | Andrei    | P@v3l    | still@gmail.com | Engineering 76 |
      | Andrei    | Pavel    | wrongg.com      | Engineering 76 |
      | Andrei    | Pavel    | okayokay@.com   | Engineering 76 |
      | Andrei    | Pavel    | @hehehe.com     | Engineering 76 |
      | Andrei    | Pavel    | good@gmail.com  |                |

    Scenario: Creating a trainee with valid data.
      Given I filled out the Create Trainee form with name "Andrei" "Pavel", email "apavel@spartaglobal.com" in "Engineering 76".
      When I click on Create New Trainee on Manage Trainee Page.
      Then I am getting "Added Andrei Pavel" message in Create Trainee form.

    Scenario: Creating a trainee with an email already registered.
      Given I have a trainee registered with "apavel@spartaglobal.com".
      And I filled out the Create Trainee form with name "Andrei" "Pavel", email "apavel@spartaglobal.com" in "Engineering 76".
      When I click on Create New Trainee on Manage Trainee Page.
      Then I am getting "apavel@spartaglobal.com already exists" message in Create Trainee form.