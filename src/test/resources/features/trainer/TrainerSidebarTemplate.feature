# new feature
# Tags: optional

Feature: TEMPLATE FOR SIDEBAR IN TRAINER HOMEPAGE

  Scenario: Trainer goes to Home Trainer Page from Home Trainer Page (Logo)
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click on Sparta Global Logo on the Home Trainer Page
    Then I am taken to the Home Trainer Page from Home Trainer Page

  Scenario: Trainer goes to Home Trainer Page from Home Trainer Page (Dashboard)
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click on Dashboard on the Home Trainer Page
    Then I am taken to the Home Trainer Page from Home Trainer Page

  Scenario: Trainer goes to Consultancy Skills Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click View on the trainer sidebar on the Home Trainer Page
    And I click on Consultancy Skills on the Home Trainer Page
    Then I am taken to the Consultancy Skills Page from Home Trainer Page

  Scenario: Trainer goes to Trainee Guide Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click View on the trainer sidebar on the Home Trainer Page
    And I click on Trainee Guide on the Home Trainer Page
    Then I am taken to the Trainee Guide Page from Home Trainer Page

  Scenario: Trainer goes to Class Management Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Class Management on the Home Trainer Page
    Then I am taken to the Class Management Page from Home Trainer Page

  Scenario: Trainer goes to Manage Trainee Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Trainee Management on the Home Trainer Page
    Then I am taken to the Manage Trainee Page from Home Trainer Page

  Scenario: Trainer goes to Add Weeks Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Add Weeks on the Home Trainer Page
    Then I am taken to the Add Weeks Page from Home Trainer Page

  Scenario: Trainer goes to Assessments Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Assessments on the Home Trainer Page
    Then I am taken to the Assessments Page from Home Trainer Page

  Scenario: Trainer goes to Enter Attendance Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Enter Attendance on the Home Trainer Page
    Then I am taken to the Enter Attendance Page from Home Trainer Page

  Scenario: Trainer goes to Weekly Attendance Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar on the Home Trainer Page
    And I click on Weekly Attendance on the Home Trainer Page
    Then I am taken to the Weekly Attendance Page from Home Trainer Page