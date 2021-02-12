# new feature
# Tags: optional

Feature: Trainee attendance page

  Scenario Outline: Clicking weeks
    Given I am on the trainee attendance page
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