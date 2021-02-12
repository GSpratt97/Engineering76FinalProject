  Feature: Report page features

  Scenario: Select Weekly Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report
    Then the selected weekly report is expanded

  Scenario: Collapse Weekly Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report
    And I select a weekly report
    Then the expanded weekly report is collapsed

  Scenario: Weekly Reports Descend Chronologically as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    Then the weekly reports are in descending order

  Scenario: Select Weekly Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I select a weekly report
    Then the selected weekly report is expanded

  Scenario: Collapse Weekly Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I select a weekly report
    And I select a weekly report
    Then the expanded weekly report is collapsed

  Scenario: Weekly Reports Descend Chronologically as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    Then the weekly reports are in descending order

  Scenario: Return to Trainee Profile as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I return to Trainee Profile
    Then I have returned to Trainee Profile

  Scenario: Navigate to Consultancy Skills from Report Details as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click View on the Trainee Sidebar
    And I click Consultancy Skills
    Then I am taken to the Consultancy Skills page from the Report page

  Scenario: Navigate to Trainee Guide from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click View on the Trainee Sidebar
    And I click Trainee Guide
    Then I am taken to the Trainee Guide Page from the Report page

  Scenario: Navigate to Feedback Form from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Feedback Form
    Then I am taken to the Feedback Form page from the Report Page

  Scenario: Navigate to Reports History from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Reports History
    Then I am taken to the Reports History Page from the Reports page

  Scenario: Navigate to Attendance History from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Attendance History
    Then I am taken to the Attendance History page from the Report page

  Scenario: Navigate to Consultancy Skills from Report Details as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Trainee Guide from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Class Management from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Trainee Management from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Add Weeks from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Assessments from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Enter Attendance from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page

  Scenario: Navigate to Weekly Attendance from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page