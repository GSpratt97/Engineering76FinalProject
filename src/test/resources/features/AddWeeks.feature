# new feature
# Tags: optional

Feature: A description

  Scenario: Add a week to a class
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    And course "Engineering 80" is currently on week 7
    When I enter course "Engineering 80" into dropdown menu
    And I press Add Week button
    Then course "Engineering 80" will be on week 8

  Scenario: try to add a week when no class is selected
    Given I am logged in as a "Trainer" and on the "Add Weeks" Page
    When no course is in dropdown
    And I press Add Week button
    Then thenTest

    Scenario: try to add a week to a class that has finished
      Given I am logged in as a "trainer" and on the "Add Weeks" Page
      And course "Engineering 65" has finished their course
      When I enter course "Engineering 65" into dropdown menu
      And I press Add Week button
      Then I am told "Engineering 65" has finished their course

  Scenario: Trainer goes to Dashboard page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click on "dashboard"
    Then I am taken to the "dashboard" Page from the "Add Weeks" page

  Scenario: Trainer goes to Consultancy Skills page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to Trainee Guide page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "trainee guide"
    Then I am taken to the "trainee guide" Page from the "Add Weeks" page

  Scenario: Trainer goes to class management page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "class management"
    Then I am taken to the "class management" Page from the "Add Weeks" page

  Scenario: Trainer goes to Trainee management page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "trainee management"
    Then I am taken to the "trainee management" Page from the "Add Weeks" page

  Scenario: Trainer goes to Add weeks page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "add weeks"
    Then I am taken to the "add weeks" Page from the "Add Weeks" page

  Scenario: Trainer goes to assessments page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "assessments"
    Then I am taken to the "assessments" Page from the "Add Weeks" page

  Scenario: Trainer goes to enter attendance page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "enter attendance"
    Then I am taken to the "enter attendance" Page from the "Add Weeks" page

  Scenario: Trainer goes to weekly attendance page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "trainer options" on the sidebar
    And I click on "weekly attendance"
    Then I am taken to the "weekly attendance" Page from the "Add Weeks" page

  Scenario: Trainer goes to change password page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click on change password on add weeks page
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer logs out from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I log out from trainer
    Then I am taken to the "login" Page from the "Add Weeks" page