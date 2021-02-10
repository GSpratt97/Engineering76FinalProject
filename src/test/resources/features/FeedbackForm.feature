Feature: Actions on the Feedback Form page

  Scenario: Entering start, stop, continue
   Given I am on the feedback page
   When I update my start, stop, continue
   Then The text should update

  Scenario: Selecting technical grade
   Given I am on the feedback page
   When I select a technical grade
   Then The grade should be selected

  Scenario: Selecting consultant grade
   Given I am on the feedback page
   When I select a consultant grade
   Then The grade should be selected