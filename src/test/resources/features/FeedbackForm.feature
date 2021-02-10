Feature: Actions on the Feedback Form page

  Scenario: Entering start, stop, continue
   Given I am on the feedback page
   When I update my start, stop, continue
   Then The text should update

  Scenario: Selecting technical
   Given I am on the feedback page
   When I select a technical
   Then The grade should be selected

  Scenario: Selecting consultant grade
   Given I am on the feedback page
   When I select a consultant grade
   Then The grade should be selected

  Scenario: Going back to the Dashboard through the logo
   Given I am on the feedback page
   When I click the Sparta global logo
   Then I should be directed to the Dashboard

  Scenario: Going back to the Dashboard through the profile
    Given I am on the feedback page
    When I click profile
    Then I should be directed to the Dashboard

  Scenario: Going to the Consultancy skills page
    Given I am on the feedback page
    When I click Consultancy Skills
    Then I should be directed to the Consultancy Skills page

  Scenario: Going to the Trainee guide
   Given I am on the feedback page
   When I click on the Trainee Guide
   Then I should be directed to the Trainee Guide page

  Scenario: Logging out
    Given I am on the feedback page
    When I click on logout
    Then I should be logged out

  Scenario: Submitting form
    Given I am on the feedback page
    And  I have filled the form
    When I click submit
    Then #to do - figure what to test here for confirmation of submitting 