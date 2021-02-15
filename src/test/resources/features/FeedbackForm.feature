Feature: Actions on the Feedback Form page

  Scenario: Entering start, stop, continue on the Feedback Page
   Given I am logged in as a trainee on the Feedback Page
   When I update my start, stop, continue on the Feedback Page
   Then The text should update on the Feedback Page

  Scenario: Selecting technical grade on the Feedback Page
   Given I am logged in as a trainee on the Feedback Page
   When I select a technical grade on the Feedback Page
   Then The technical grade should be selected on the Feedback Page

  Scenario: Selecting consultant grade on the Feedback Page
   Given I am logged in as a trainee on the Feedback Page
   When I select a consultant grade on the Feedback Page
   Then The consultant grade should be selected on the Feedback Page

  Scenario: Going back to the Dashboard through the logo
   Given I am logged in as a trainee on the Feedback Page
   When I click the Sparta global logo from the Feedback Page
   Then I should be directed to the Dashboard from the Feedback Page

  Scenario: Going back to the Dashboard through the profile
    Given I am logged in as a trainee on the Feedback Page
    When I click profile from the Feedback Page
    Then I should be directed to the Dashboard from the Feedback Page

  Scenario: Going to the Consultancy skills page
    Given I am logged in as a trainee on the Feedback Page
    When I click Consultancy Skills from the Feedback Page
    Then I should be directed to the Consultancy Skills page from the Feedback Page

  Scenario: Going to the Trainee guide
   Given I am logged in as a trainee on the Feedback Page
   When I click on the Trainee Guide from the Feedback Page
   Then I should be directed to the Trainee Guide page from the Feedback Page

  Scenario: Logging out
    Given I am logged in as a trainee on the Feedback Page
    When I click on logout from the Feedback Page
    Then I should be logged out from the Feedback Page
    