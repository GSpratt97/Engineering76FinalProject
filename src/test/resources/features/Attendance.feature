# new feature
# Tags: optional

Feature: Attendance page

  Scenario: Navigate back to trainee profile page using back button
    Given I am logged in as a trainer and on the Trainee Attendance page
    When I click on the back to profile button
    Then I am taken to the trainee profile page from the trainer attendance page

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

  Scenario Outline: Clicking and unclicking week attendance rows on trainee attendance page
    Given I am logged in as a trainee and on the Trainee Attendance page
    When I click on week <number> twice
    Then The dropdown for week <number> will not be toggled
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

  Scenario Outline: Clicking week attendance rows on trainer attendance page
    Given I am logged in as a trainer and on the Trainee Attendance page
    When I click on week <number> as a trainer
    Then The dropdown for week <number> will be toggled as a trainer
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
      | 13     |
      | 14     |

  Scenario Outline: Clicking and unclicking week attendance rows on trainer attendance page
    Given I am logged in as a trainer and on the Trainee Attendance page
    When I click on week <number> twice as a trainer
    Then The dropdown for week <number> will not be toggled as a trainer
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
      | 13     |
      | 14     |

  Scenario Outline: Checking number of days in week is correct trainee
    Given I am logged in as a trainee and on the Trainee Attendance page
    When I check the number of days in week <number>
    Then There will be 5 days in week <number>
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

  Scenario Outline: Checking number of days in week is correct trainer
    Given I am logged in as a trainer and on the Trainee Attendance page
    When I check the number of days in week <number> as a trainer
    Then There will be 5 days in week <number> as a trainer
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
      | 13     |
      | 14     |