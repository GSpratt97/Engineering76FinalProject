Feature: Change Password

  Scenario: Change password as trainer
    Given I am logged in as a trainer
    And I am on the change password page
    When I change my password from "startrek" to "startrek"
    And I log out
    Then I am able to log back in as a trainer with new password "startrek"

    Scenario: Change password as trainee
      Given I am logged in as a trainee
      And I am on the change password page
      When I change my password from "test" to "test"
      And I log out
      Then I am able to log back in as a trainee with new password "test"