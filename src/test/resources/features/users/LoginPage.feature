Feature: Logging in

  Scenario: Logging in as trainer
    Given I am on the login page
    When I log in with trainer email and password
    Then I am taken to the trainer home page from the login page

  Scenario: Logging in as trainee
    Given I am on the login page
    When I log in with trainee email and password
    Then I am taken to the trainee home page from the login page

  Scenario: Wrong details fails login
    Given I am on the login page
    When I log in with incorrect email and password
    Then I am taken to the login error page from the login page

  Scenario: Login in from error page as a trainer
    Given I am on the login page
    When I log in with incorrect email and password
    And I log in as a trainer with correct details
    Then  I am taken to the trainer home page from the login page

  Scenario: Login in from error page as a trainee
    Given I am on the login page
    When I log in with incorrect email and password
    And I log in as a trainee with correct details
    Then  I am taken to the trainee home page from the login page

  Scenario: Logging in from logout page as trainer
    Given I have been logged out
    When I log in with trainer email and password
    Then I am taken to the trainer home page from the login page

  Scenario: Logging in from logout page as trainee
    Given I have been logged out
    When I log in with trainee email and password
    Then I am taken to the trainee home page from the login page
