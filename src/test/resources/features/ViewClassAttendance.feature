Feature: Viewing class attendance

  Scenario Outline: Viewing the attendance for weeks <number> on Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the tabs for weeks <number> on the Weekly Attendance page
    Then The week <number> tabs should expand on the Weekly Attendance page
    Examples:
      | number |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
      | 6      |
      | 7      |
      | 8      |
      | 9      |
      | 10     |
      | 11     |
      | 12     |

  Scenario Outline: Closing the attendance tabs for weeks <number> on Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    And I have opened the attendance tabs for weeks <number> on the Weekly Attendance page
    When I click on the tabs for weeks <number> on the Weekly Attendance page
    Then The week 1, 2 and 3 tabs should close on the Weekly Attendance page
    Examples:
      | number |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
      | 6      |
      | 7      |
      | 8      |
      | 9      |
      | 10     |
      | 11     |
      | 12     |

  Scenario: Clicking the week 1 tab 6 times in quick succession on Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the week 1 tab 6 times in quick succession on the Weekly Attendance page
    Then The week 1 tab should open and close 3 times on the Weekly Attendance page
    And The week 1 attendance table should not be visible at all on the Weekly Attendance page

  Scenario: Trainer goes to Trainer Home page from Weekly Attendance by clicking Dashboard
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Dashboard on the trainer sidebar on the Weekly Attendance page
    Then I am taken to the Home Trainer page from the Weekly Attendance page

  Scenario: Trainer goes to Trainer Home page from Weekly Attendance by clicking the Sparta Global logo
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click the Sparta Global logo on the trainer sidebar on the Weekly Attendance page
    Then I am taken to the Home Trainer page from the Weekly Attendance page

  Scenario: Trainer goes to Consultancy Skills page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click View on the trainer sidebar on the Weekly Attendance page
    And I click on Consultancy Skills on the Weekly Attendance page
    Then I am taken to the Consultancy Skills page from the Weekly Attendance page

  Scenario: Trainer goes to Trainee Guide page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click View on the trainer sidebar on the Weekly Attendance page
    And I click on Trainee Guide on the Weekly Attendance page
    Then I am taken to the Trainee Guide page from the Weekly Attendance Page

  Scenario: Trainer goes to Class Management page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Class Management on the Weekly Attendance page
    Then I am taken to the Class Management page from the Weekly Attendance page

  Scenario: Trainer goes to Manage Trainee page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Trainee Management on the Weekly Attendance page
    Then I am taken to the Manage Trainee page from the Weekly Attendance page

  Scenario: Trainer goes to Add Weeks page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Add Weeks on the Weekly Attendance page
    Then I am taken to the Add Weeks page from the Weekly Attendance page

  Scenario: Trainer goes to Assessments page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Assessments on the Weekly Attendance page
    Then I am taken to the Assessments page from the Weekly Attendance page

  Scenario: Trainer goes to Enter Attendance page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Enter Attendance on the Weekly Attendance page
    Then I am taken to the Enter Attendance page from the Weekly Attendance page

  Scenario: Trainer goes to Weekly Attendance page from Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click Trainer Options on the trainer sidebar on the Weekly Attendance page
    And I click on Weekly Attendance on the Weekly Attendance page
    Then I am taken to the Weekly Attendance page from the Weekly Attendance page