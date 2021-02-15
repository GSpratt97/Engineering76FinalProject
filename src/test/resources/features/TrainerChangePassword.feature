Feature: Change Password Page as Trainer

  Scenario: Change password as Trainer
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I change my password as a Trainer from "startrek" to "startrek"
    And I log out from Trainer page
    Then I am able to log back in as a Trainer with new password "startrek"

  Scenario: Trainer goes to Home Trainer Page from Trainer Change Password Page (Logo)
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click on Sparta Global Logo on the Trainer Change Password Page
    Then I am taken to the Home Trainer Page from Trainer Change Password Page

  Scenario: Trainer goes to Home Trainer Page from Trainer Change Password Page (Dashboard)
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click on Dashboard on the Trainer Change Password Page
    Then I am taken to the Home Trainer Page from Trainer Change Password Page

  Scenario: Trainer goes to Consultancy Skills Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click View on the Trainer sidebar on the Trainer Change Password Page
    And I click on Consultancy Skills on the Trainer Change Password Page
    Then I am taken to the Consultancy Skills Page from Trainer Change Password Page

  Scenario: Trainer goes to Trainee Guide Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click View on the Trainer sidebar on the Trainer Change Password Page
    And I click on Trainee Guide on the Trainer Change Password Page
    Then I am taken to the Trainee Guide Page from Trainer Change Password Page

  Scenario: Trainer goes to Class Management Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Class Management on the Trainer Change Password Page
    Then I am taken to the Class Management Page from Trainer Change Password Page

  Scenario: Trainer goes to Manage Trainee Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Trainee Management on the Trainer Change Password Page
    Then I am taken to the Manage Trainee Page from Trainer Change Password Page

  Scenario: Trainer goes to Add Weeks Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Add Weeks on the Trainer Change Password Page
    Then I am taken to the Add Weeks Page from Trainer Change Password Page

  Scenario: Trainer goes to Assessments Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Assessments on the Trainer Change Password Page
    Then I am taken to the Assessments Page from Trainer Change Password Page

  Scenario: Trainer goes to Enter Attendance Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Enter Attendance on the Trainer Change Password Page
    Then I am taken to the Enter Attendance Page from Trainer Change Password Page

  Scenario: Trainer goes to Weekly Attendance Page from Trainer Change Password Page
    Given I am logged in as a Trainer and on the Trainer Change Password Page
    When I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page
    And I click on Weekly Attendance on the Trainer Change Password Page
    Then I am taken to the Weekly Attendance Page from Trainer Change Password Page