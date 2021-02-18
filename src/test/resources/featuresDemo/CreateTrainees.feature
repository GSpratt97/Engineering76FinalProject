Feature: Creating a trainee profile

  Background: Logged in as a trainer and navigated to Manage Trainee Page.
    Given I am logged in as a Trainer and on the Manage Trainee Page.

  @CreatingTrainee("AndreiPavel")
  Scenario: Creating a trainee with valid data.
    Given I filled out the Create Trainee form with name "Andrei" "Pavel", email "apavel@spartaglobal.com" in "Engineering 76".
    When I click on Create New Trainee on Manage Trainee Page.
    Then I am getting "Added Andrei Pavel" message in Create Trainee form.


