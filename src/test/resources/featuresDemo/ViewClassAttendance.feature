# new feature
# Tags: optional

Feature: A description

  Scenario: After clicking the week 1 tab 20 times in quick succession on Weekly Attendance and closing the tab, no table should be shown
    Given I am logged in as a trainer and on the Weekly Attendance page
    When I click on the week 1 tab 20 times in quick succession on the Weekly Attendance page
    And If the week 1 tab is open, it is closed
    Then The week 1 attendance table should not be visible at all on the Weekly Attendance page