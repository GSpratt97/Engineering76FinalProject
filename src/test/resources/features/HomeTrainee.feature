# new feature
# Tags: optional

@HomeTrainee
Feature: Home for Trainees features

  Scenario: Trainee sees correct details on the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I am on the Home Trainee Page
    Then I can see my Trainee details on the Home Trainee Page

  Scenario: Trainee sees correct Attendance on the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I am on the Home Trainee Page
    Then I can see my Attendance details on the Home Trainee Page

  Scenario: Trainee sees correct Grade for previous week on the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I am on the Home Trainee Page
    Then I can see my Grade for previous week on the Home Trainee Page

  Scenario: Trainee goes to the Attendance Breakdown from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Attendance Details on the Home Trainee Page
    Then I am taken to the Weekly Attendance Page from the Home Trainee Page

  Scenario: Trainee goes to the Trainee Report from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Report Details on the Home Trainee Page
    Then I am taken to the Trainee Report Page from the Home Trainee Page

  Scenario: Trainee goes to the Home Trainee Page from the Home Trainee Page (Logo)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Sparta Global Logo on the Home Trainee Page
    Then I am taken to the Home Trainee Page from the Home Trainee Page

  Scenario: Trainee goes to the Home Trainee Page from the Home Trainee Page (Profile)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Profile on the Home Trainee Page
    Then I am taken to the Home Trainee Page from the Home Trainee Page

  Scenario: Trainee goes to the Consultancy Skills Page from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar on the Home Trainee Page
    And I click on Consultancy Skills on the Home Trainee Page
    Then I am taken to the Consultancy Skills Page from the Home Trainee Page

  Scenario: Trainee goes to the Trainee Guide Page from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar on the Home Trainee Page
    And I click on Trainee Guide on the Home Trainee Page
    Then I am taken to the Trainee Guide Page from the Home Trainee Page

  Scenario: Trainee goes to the Feedback Form Page from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Feedback Form on the Home Trainee Page
    Then I am taken to the Feedback Form from the Home Trainee Page

  Scenario: Trainee goes to the Report Trainee Page from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Report Trainee on the Home Trainee Page
    Then I am taken to the Report Trainee Page from the Home Trainee Page

  Scenario: Trainee goes to the Trainee Attendance Page from the Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Attendance History on the Home Trainee Page
    Then I am taken to the Trainee Attendance Page from the Home Trainee Page
