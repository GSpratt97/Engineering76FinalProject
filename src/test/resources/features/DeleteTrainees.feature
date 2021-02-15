@ManageTrainee @DeleteTrainee
Feature: Deleting a trainee profile

  Background: Logged in as a trainer and navigated to Manage Trainee Page.
    Given I am logged in as a Trainer and on the Manage Trainee Page.

  Scenario: Deleting a trainee without selecting one.
    Given I am not selecting any trainee in Delete Trainee form.
    When I click on Delete Trainee on Manage Trainee Page.
    Then I am getting a validation warning for invalid data in Delete Trainee form.

  @DeletingTrainee
  Scenario: Deleting a trainee as normal.
    Given I have created a trainee with name "Andrei" "Pavel", email "apavel@spartaglobal.com" in "Engineering 76".
    And I am selecting "Andrei Pavel" trainee in Delete Trainee form.
    When I click on Delete Trainee on Manage Trainee Page.
    Then I am getting "Deleted trainee Andrei Pavel" message in Create Trainee form.

