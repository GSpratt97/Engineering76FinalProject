# new feature
# Tags: optional

Feature: Attendance page features

  @AttendMe
  Scenario: Add Attendance
    Given I am on the attendance page
    When I select a trainee
    And Select the desired radio button
    And Select a date within the course limits
    Then I will receive a completed successfully message

    @AttendMe
    Scenario: Change attendance type
      Given I am signed in for radioButton check
      When I change the radio button attendance type
      And I click submit
      Then I will still receive a completed successfully message

      @AttendMe
        Scenario: Error message
          Given I am signed in on the attendance page
          When I put in a date that's outside the course bounds
          Then I should receive an error message