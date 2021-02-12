# new feature
# Tags: optional

Feature: TEMPLATE FOR SIDEBAR IN TRAINEE HOMEPAGE

  Scenario: Trainee goes to Home Trainee Page from Home Trainee Page (Logo)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Sparta Global Logo on the Home Trainee Page
    Then I am taken to the Home Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Home Trainee Page from Home Trainee Page (Profile)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Profile on the Home Trainee Page
    Then I am taken to the Home Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Consultancy Skills Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar on the Home Trainee Page
    And I click on Consultancy Skills on the Home Trainee Page
    Then I am taken to the Consultancy Skills Page from Home Trainee Page

  Scenario: Trainee goes to Trainee Guide Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar on the Home Trainee Page
    And I click on Trainee Guide on the Home Trainee Page
    Then I am taken to the Trainee Guide Page from Home Trainee Page

  Scenario: Trainee goes to Feedback Form Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Feedback Form on the Home Trainee Page
    Then I am taken to the Feedback Form from Home Trainee Page

  Scenario: Trainee goes to Report Trainee Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Report Trainee on the Home Trainee Page
    Then I am taken to the Report Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Add Weeks Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar on the Home Trainee Page
    And I click on Add Weeks on the Home Trainee Page
    Then I am taken to the Add Weeks Page from Home Trainee Page