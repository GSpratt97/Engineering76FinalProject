Feature: Actions on the Assessments Page

  Scenario: Selecting Trainee
    Given I am on the Assessments Page
    When I select a Trainee
    Then I stay on the Assessments Page

  Scenario: Clicking Trainee
    Given I am on the Assessments Page
    When I click on a Trainee
    Then I am taken to the Assessments Breakdown Page

