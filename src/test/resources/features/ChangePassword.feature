Feature: Change Password

  Scenario: Change password as trainer
    Given I am logged in as a trainer on the change password page
    When I change my password as a trainer from "startrek" to "startrek"
    And I log out from trainer page
    Then I am able to log back in as a trainer with new password "startrek"

  Scenario: Change password as trainee
    Given  I am logged in as a trainee on the change password page
    When I change my password as a trainee from "test" to "test"
    And I log out from trainee page
    Then I am able to log back in as a trainee with new password "test"