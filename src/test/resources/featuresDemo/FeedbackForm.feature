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


    