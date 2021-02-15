# new feature
# Tags: optional

Feature: Trainee attendance page

  Scenario Outline: Clicking week attendance rows on trainee attendance page
    Given I am logged in as a trainee and on the Trainee Attendance page
    When I click on week <number>
    Then The dropdown for week <number> will be toggled
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