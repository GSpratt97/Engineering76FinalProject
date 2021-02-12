Feature: Report page features

  Scenario: Select Weekly Report as Trainee
    Given I am logged in as a Trainee and I am on the Report page
    When I select a weekly report
    Then the selected weekly report is expanded

    Scenario: Collapse Weekly Report as Trainee
      Given I am logged in as a Trainee and I am on the Report page
      When I select a weekly report
      And I select a weekly report
      Then the expanded weekly report is collapsed

      Scenario: Weekly Reports Descend Chronologically as Trainee
        Given I am logged in as a Trainee and I am on the Report page
        Then the weekly reports are in descending order

        Scenario: Select Weekly Report as Trainer
          Given I am logged in as a Trainer and I am on Bill Birds Report Page
          When I select a weekly report
          Then the selected weekly report is expanded

          Scenario: Collapse Weekly Report as Trainer
            Given I am logged in as a Trainer and I am on Bill Birds Report Page
            When I select a weekly report
            And I select a weekly report
            Then the expanded weekly report is collapsed

            Scenario: Weekly Reports Descend Chronologically as Trainer
              Given I am logged in as a Trainer and I am on Bill Birds Report Page
              Then the weekly reports are in descending order

              Scenario: Return to Trainee Profile as Trainer
                Given I am logged in as a Trainer and I am on Bill Birds Report Page
                When I return to Trainee Profile
                Then I have returned to Trainee Profile