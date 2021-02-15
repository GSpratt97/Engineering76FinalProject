# new feature
# Tags: optional

Feature: A description

  Scenario: Change password as Trainee
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I change my password as a Trainee from "test" to "test"
    And I log out from Trainee page
    Then I am able to log back in as a Trainee with new password "test"

  Scenario: Trainee goes to Home Trainee Page from Trainee Change Password Page (Logo)
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click on Sparta Global Logo on the Trainee Change Password Page
    Then I am taken to the Home Trainee Page from Trainee Change Password Page

  Scenario: Trainee goes to Home Trainee Page from Trainee Change Password Page (Profile)
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click on Profile on the Trainee Change Password Page
    Then I am taken to the Home Trainee Page from Trainee Change Password Page

  Scenario: Trainee goes to Consultancy Skills Page from Trainee Change Password Page
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click View on the Trainee sidebar on the Trainee Change Password Page
    And I click on Consultancy Skills on the Trainee Change Password Page
    Then I am taken to the Consultancy Skills Page from Trainee Change Password Page

  Scenario: Trainee goes to Trainee Guide Page from Trainee Change Password Page
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click View on the Trainee sidebar on the Trainee Change Password Page
    And I click on Trainee Guide on the Trainee Change Password Page
    Then I am taken to the Trainee Guide Page from Trainee Change Password Page

  Scenario: Trainee goes to Feedback Form Page from Trainee Change Password Page
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click Trainee Options on the Trainee sidebar on the Trainee Change Password Page
    And I click on Feedback Form on the Trainee Change Password Page
    Then I am taken to the Feedback Form from Trainee Change Password Page

  Scenario: Trainee goes to Report Trainee Page from Trainee Change Password Page
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click Trainee Options on the Trainee sidebar on the Trainee Change Password Page
    And I click on Report Trainee on the Trainee Change Password Page
    Then I am taken to the Report Trainee Page from Trainee Change Password Page

  Scenario: Trainee goes to Attendance Page from Trainee Change Password Page
    Given I am logged in as a Trainee and on the Trainee Change Password Page
    When I click Trainee Options on the Trainee sidebar on the Trainee Change Password Page
    And I click on Attendance on the Trainee Change Password Page
    Then I am taken to the Attendance Page from Trainee Change Password Page