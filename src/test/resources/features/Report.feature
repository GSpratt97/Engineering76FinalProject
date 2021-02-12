Feature: Report page features

  Scenario: Select Weekly Report
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report
    Then the selected weekly report is expanded