# new feature
# Tags: optional

Feature: Attendance page features

  @AttendMeDone
  Scenario: Add Attendance
    Given I am on the attendance page
    When I select a trainee
    And Select the desired radio button
    And Select a date within the course limits
    Then I will receive a completed successfully message

    @AttendMeDone
    Scenario: Change attendance type
      Given I am on the attendance page
      When Select the desired radio button
      And Select a date within the course limits
      And I click submit Attendance
      Then I will receive a completed successfully message

      @AttendMeDone
        Scenario: Error message
          Given I am on the attendance page
          When I put in a date that's outside the course bounds
          Then I should receive an error message

        @AttendMeDone
        Scenario: Correct date added to
          Given I have selected a date on Attendance Page
          When I click submit Attendance
          Then I will receive a completed successfully message with a matching date

          @AttendMeDone
          Scenario Outline: Multiple additions of trainees
            Given I am on the attendance page
            When I change the trainee to <Trainee>
            Then I get a success message containing <TraineeSuccess>
            Examples:
              | Trainee  | TraineeSuccess |
              | "Reece"  | "Reece"        |
              | "David"  | "David"        |
              | "Toyin"  | "Toyin"        |
              | "Shahid" | "Shahid"       |

