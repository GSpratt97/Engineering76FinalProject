# new feature
# Tags: optional

Feature: Assessment breakdown page feature

  Scenario: Clicking the + icon for more details on SQL module for trainee Bill Bird
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click the plus icon on the module SQL
    Then I stay on the assessment breakdown page with the SQL module breakdown

  Scenario: Clicking the + icon for more details on NotSQL module for trainee Bill Bird
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click the plus icon on the module NotSQL
    Then I stay on the assessment breakdown page with the NotSQL breakdown

  Scenario: Trainer goes to Consultancy Skills Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click View on the trainer sidebar on the Assessment Breakdown Page
    And I click on Consultancy Skills on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Consultancy Skills Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Trainee Guide Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click View on the trainer sidebar on the Assessment Breakdown Page
    And I click on Trainee Guide on the trainer sidebar the Assessment Breakdown Page
    Then I am taken to the Trainee Guide Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Class Management Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Class Management on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Class Management Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Manage Trainee Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Trainee Management on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Manage Trainee Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Add Weeks Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Add Weeks on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Add Weeks Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Assessments Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Assessments on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Assessments Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Enter Attendance Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Enter Attendance on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Enter Attendance Page from the Assessment Breakdown Page

  Scenario: Trainer goes to Weekly Attendance Page from Assessment Breakdown Page
    Given I am logged in as a trainer and on the Assessment Breakdown Page
    When I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page
    And I click on Weekly Attendance on the trainer sidebar on the Assessment Breakdown Page
    Then I am taken to the Weekly Attendance Page from the Assessment Breakdown Page