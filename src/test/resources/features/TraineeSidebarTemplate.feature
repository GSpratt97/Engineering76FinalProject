# new feature
# Tags: optional

Feature: TEMPLATE FOR SIDEBAR IN TRAINEE HOMEPAGE

  Scenario: Trainee goes to Home Trainee Page from Home Trainee Page (Logo)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Sparta Global Logo
    Then I am taken to the Home Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Home Trainee Page from Home Trainee Page (Profile)
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click on Profile
    Then I am taken to the Home Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Consultancy Skills Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar
    And I click on Consultancy Skills
    Then I am taken to the Consultancy Skills Page from Home Trainee Page

  Scenario: Trainee goes to Trainee Guide Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click View on the trainee sidebar
    And I click on Trainee Guide
    Then I am taken to the Trainee Guide Page from Home Trainee Page

  Scenario: Trainee goes to Feedback Form Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar
    And I click on Feedback Form
    Then I am taken to the Feedback Form from Home Trainee Page

  Scenario: Trainee goes to Report Trainee Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar
    And I click on Report Trainee
    Then I am taken to the Report Trainee Page from Home Trainee Page

  Scenario: Trainee goes to Add Weeks Page from Home Trainee Page
    Given I am logged in as a trainee and on the Home Trainee Page
    When I click Trainee Options on the trainee sidebar
    And I click on Add Weeks
    Then I am taken to the Add Weeks Page from Home Trainee Page