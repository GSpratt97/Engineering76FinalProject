Feature: Logging in

  Scenario: Logging in as trainer
    Given I am on the login page
    When I enter my trainer email and password
    And I click submit
    Then I am on the trainer home page

  Scenario: Logging in as trainee
    Given I am on the login page
    When I enter my trainee email and password
    And I click submit
    Then I am on the trainee home page