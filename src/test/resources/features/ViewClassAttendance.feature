Feature: Viewing class attendance

  Scenario Outline: Viewing the attendance for week <number> on Weekly Attendance
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the tab for week <number> on the Weekly Attendance page
    Then The week <number> tab should expand on the Weekly Attendance page
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

  Scenario Outline: Closing the attendance tabs for week <number> on Weekly Attendance after opening them
    Given I am logged in as a trainer and on the Weekly Attendance page
    And I have opened the attendance tab for week <number> on the Weekly Attendance page
    When I click on the tab for week <number> on the Weekly Attendance page
    Then The week <number> tab should close on the Weekly Attendance page
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

  Scenario Outline: Opening the tab for each week and checking that each one has 5 days
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the tab for week <number> on the Weekly Attendance page
    Then The week <number> tab should show a table with 5 columns
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

  Scenario: Clicking the week 1 tab 10 times in quick succession on Weekly Attendance should open and close it 5 times
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the week 1 tab 10 times in quick succession on the Weekly Attendance page
    Then The week 1 tab should be closed on the Weekly Attendance page

  Scenario: After clicking the week 1 tab 20 times in quick succession on Weekly Attendance and closing the tab, no table should be shown
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the week 1 tab 20 times in quick succession on the Weekly Attendance page
    And If the week 1 tab is open, it is closed
    Then The week 1 attendance table should not be visible at all on the Weekly Attendance page

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