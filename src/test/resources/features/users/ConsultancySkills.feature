# new feature
# Tags: optional

Feature: As a user i want to able to use the Consultancy skills page and click different buttons

  Scenario: Testing if the studious collapse menu button works
    Given I am logged in as Trainer and on consultancy skills page
    When I am click on the Studious collapse card
    Then The Studious card will shrink to tab

  Scenario: Testing if the all collapse menu button works
    Given I am logged in as Trainer and on consultancy skills page
    When I click tabs to collapse all the menus
    Then All the cards will shrink

  Scenario: Testing if the button "See what these skills make" works
    Given I am logged in as Trainer and on consultancy skills page
    When I click the button See what these skills make
    Then An ideal consultant image appears

  Scenario: Testing if the button "Back to Dashboard" works
    Given I am logged in as Trainer and on consultancy skills page
    When I click the button Back to Dashboard
    Then The dashboard opens

  Scenario: Testing if the button "Back to Profile" works
    Given I am logged in as Trainee and on consultancy skills page
    When I click the button Back to Profile with trainee login
    Then The profile opens