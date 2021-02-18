  Feature: Report page features

  Scenario Outline: Select Weekly Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report as a Trainee on week <number>
    Then the selected weekly report is expanded as Trainee
    Examples:
      | number |
      | 12     |
      | 11     |
      | 10     |
      | 9      |
      | 8      |
      | 7      |
      | 6      |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |

  Scenario Outline: Collapse Weekly Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report as a Trainee on week <number>
    And I select a weekly report as a Trainee on week <number>
    Then the expanded weekly report is collapsed as Trainee
    Examples:
      | number |
      | 12     |
      | 11     |
      | 10     |
      | 9      |
      | 8      |
      | 7      |
      | 6      |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |

  Scenario: Weekly Reports Descend Chronologically as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    Then the weekly reports are in descending order as Trainee

  Scenario Outline: Select Weekly Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I select a weekly report as a Trainer on week <number>
    Then the selected weekly report is expanded as Trainer
    Examples:
      | number |
      | 12     |
      | 11     |
      | 10     |
      | 9      |
      | 8      |
      | 7      |
      | 6      |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |

  Scenario Outline: Collapse Weekly Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I select a weekly report as a Trainer on week <number>
    And I select a weekly report as a Trainer on week <number>
    Then the expanded weekly report is collapsed as Trainer
    Examples:
      | number |
      | 12     |
      | 11     |
      | 10     |
      | 9      |
      | 8      |
      | 7      |
      | 6      |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |

  Scenario: Weekly Reports Descend Chronologically as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    Then the weekly reports are in descending order as Trainer

  Scenario: Return to Trainee Profile as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I return to Trainee Profile
    Then I have returned to Trainee Profile

  Scenario: Navigate to Consultancy Skills from Report Details as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click View on the Trainee Sidebar
    And I click Consultancy Skills as a Trainee
    Then I am taken to the Trainee Consultancy Skills page

  Scenario: Navigate to Trainee Guide from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click View on the Trainee Sidebar
    And I click Trainee Guide as a Trainee
    Then I am taken to the Trainee Guide page

  Scenario: Navigate to Feedback Form from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Feedback Form
    Then I am taken to the Trainee Feedback Form page

  Scenario: Navigate to Reports History from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Reports History
    Then I am taken to the Trainee Reports History page

  Scenario: Navigate to Attendance History from Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I click Trainee Options on the Trainee Sidebar
    And I click Attendance History
    Then I am taken to the Trainee Attendance History page

  Scenario: Navigate to Consultancy Skills from Report Details as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click View on the Trainer Sidebar
    And I click Consultancy Skills as a Trainer
    Then I am taken to the Trainer Consultancy Skills page

  Scenario: Navigate to Trainee Guide from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click View on the Trainer Sidebar
    And I click Trainee Guide as a Trainer
    Then I am taken to the Trainer Trainee Guide page

  Scenario: Navigate to Class Management from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Class Management
    Then I am taken to the Class Management page

  Scenario: Navigate to Trainee Management from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Trainee Management
    Then I am taken to the Trainee Management page

  Scenario: Navigate to Add Weeks from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Add Weeks
    Then I am taken to the Add Weeks page

  Scenario: Navigate to Assessments from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Assessments
    Then I am taken to the Assessments page

  Scenario: Navigate to Enter Attendance from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Enter Attendance
    Then I am taken to the Enter Attendance page

  Scenario: Navigate to Weekly Attendance from Report as Trainer
    Given I am logged in as a Trainer and I am on Bill Birds Report Page
    When I click Trainer Options on the Trainer Sidebar
    And I click Weekly Attendance
    Then I am taken to the Weekly Attendance page