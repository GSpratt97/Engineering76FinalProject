# new feature
# Tags: optional

Feature: A description

  Scenario: A scenario
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    And course "Engineering 65" is currently on week 1
    When I enter course "Engineering 65" into dropdown menu
    And I press Add Week button
    Then course "Engineering 65" will be on week 2

    Scenario:
      Given I am logged in as a "Trainer" and on the "Add Weeks" Page
      When no course is in dropdown
      And I press Add Week button
      Then ...

  Scenario: Trainer goes to Dashboard page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to Consultancy Skills page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to Trainee Guide page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to class management page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to Trainee management page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to Add weeks page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to assessments page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to enter attendance page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to weekly attendance page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer goes to change password page from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page

  Scenario: Trainer logs out from Add Weeks page
    Given I am logged in as a "trainer" and on the "Add Weeks" Page
    When I click "View" on the sidebar
    And I click on "Consultancy Skills"
    Then I am taken to the "Consultancy Skills" Page from the "Add Weeks" page