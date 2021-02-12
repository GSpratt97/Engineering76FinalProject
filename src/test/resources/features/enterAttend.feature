# new feature
# Tags: optional

Feature: Attendance page features

  @AttendanceEntry
  Scenario: Add Attendance
    Given I am logged in as a trainer and I am on the attendance page
    When I select a trainee on attendance page
    And Select the desired radio button for attendance type
    And Select a date within the course limits on attendance page
    Then I will receive a completed successfully message on attendance page

    @AttendanceEntry
    Scenario: Change attendance type
      Given I am logged in as a trainer and I am on the attendance page
      When Select the desired radio button for attendance type
      And Select a date within the course limits on attendance page
      And I click submit Attendance
      Then I will receive a completed successfully message on attendance page

      @AttendanceEntry
        Scenario: Error message
          Given I am logged in as a trainer and I am on the attendance page
          When I put in a date that's outside the course bounds on attendance page
          Then I will receive an error message on attendance page

        @AttendanceEntry
        Scenario: Correct date added to
          Given I am logged in as a trainer and I am on the attendance page
          And I have selected a date on Attendance Page
          When I click submit Attendance
          Then I will receive a completed successfully message with a matching date

          @AttendanceMultiple
          Scenario Outline: Multiple additions of trainees
            Given I am logged in as a trainer and I am on the attendance page
            When I change the trainee to <Trainee>
            Then I get a success message containing <TraineeSuccess>
            Examples:
              | Trainee  | TraineeSuccess |
              | "Reece"  | "Reece"        |
              | "David"  | "David"        |
              | "Toyin"  | "Toyin"        |
              | "Shahid" | "Shahid"       |