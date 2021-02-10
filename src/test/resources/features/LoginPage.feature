Feature: Logging in

  Scenario: Logging in as trainer
    Given I am on the login page
    When I log in with trainer email and password
    Then I am on the trainer home page

  Scenario: Logging in as trainee
    Given I am on the login page
    When I log in with trainee email and password
    Then I am on the trainee home page

    Scenario: Wrong details fails login
      Given I am on the login page
      When I log in with incorrect email and password
      Then I am on the login error page

      Scenario: Logging in from logout page as trainer
        Given I have been logged out
        When I log in with trainer email and password
        Then I am on the trainer home page

        Scenario: Logging in from logout page as trainee
          Given I have been logged out
          When I log in with trainee email and password
          Then I am on the trainee home page