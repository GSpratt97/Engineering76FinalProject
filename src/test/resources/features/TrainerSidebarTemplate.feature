# new feature
# Tags: optional

Feature: TEMPLATE FOR SIDEBAR IN TRAINER HOMEPAGE

  Scenario: Trainer goes to Home Trainer Page from Home Trainer Page (Logo)
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click on Sparta Global Logo
    Then I am taken to the Home Trainer Page from Home Trainer Page

  Scenario: Trainer goes to Home Trainer Page from Home Trainer Page (Dashboard)
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click on Dashboard
    Then I am taken to the Home Trainer Page from Home Trainer Page

  Scenario: Trainer goes to Consultancy Skills Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click View on the trainer sidebar
    And I click on Consultancy Skills
    Then I am taken to the Consultancy Skills Page from Home Trainer Page

  Scenario: Trainer goes to Trainee Guide Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click View on the trainer sidebar
    And I click on Trainee Guide
    Then I am taken to the Trainee Guide Page from Home Trainer Page

  Scenario: Trainer goes to Class Management Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Class Management
    Then I am taken to the Class Management Page from Home Trainer Page

  Scenario: Trainer goes to Manage Trainee Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Trainee Management
    Then I am taken to the Manage Trainee Page from Home Trainer Page

  Scenario: Trainer goes to Add Weeks Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Add Weeks
    Then I am taken to the Add Weeks Page from Home Trainer Page

  Scenario: Trainer goes to Assessments Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Assessments
    Then I am taken to the Assessments Page from Home Trainer Page

  Scenario: Trainer goes to Enter Attendance Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Enter Attendance
    Then I am taken to the Enter Attendance Page from Home Trainer Page

  Scenario: Trainer goes to Weekly Attendance Page from Home Trainer Page
    Given I am logged in as a trainer and on the Home Trainer Page
    When I click Trainer Options on the trainer sidebar
    And I click on Weekly Attendance
    Then I am taken to the Weekly Attendance Page from Home Trainer Page