Feature: Actions on the TraineeProfile Page

  # Currently Scenarios only work for "Bill Bird" as no link to SQL to get data (input manually)
  # and no other trainee currently has comprehensive data to test

    # Scenario for Trainee Details

  Scenario: Correct Trainee details on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I look at the Trainee Details of the trainee on the Trainee Profile Page
    Then I see the details of "Bill Bird" on the Trainee Profile Page

    # Scenario for Attendance Breakdown

  Scenario: Correct Attendance Breakdown on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I look at the Attendance Breakdown of the trainee on the Trainee Profile Page
    Then I see the Attendance Breakdown of "Bill Bird" on the Trainee Profile Page

    # Scenario for Grades for Previous Week

  Scenario:  Correct Grades for Previous Week on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I look at the Grades for Previous Week of the trainee on the Trainee Profile Page
    Then I see the Grades for Previous Week of "Bill Bird" on the Trainee Profile Page

    # Scenario for General SQL Results

  Scenario: Correct General SQL Results on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I look at the General SQL Results of the trainee on the Trainee Profile Page
    Then I see the General SQL Results of "Bill Bird" on the Trainee Profile Page

    # Scenario for General Not SQL Results

  Scenario: Correct General Not SQL Results on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I look at the General Not SQL Results of the trainee on the Trainee Profile Page
    Then I see the General Not SQL Results of "Bill Bird" on the Trainee Profile Page

    # Scenario for Specific SQL Results using toggle

  Scenario: Can see a breakdown of SQL Results on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click on the toggle SQL breakdown button on the Trainee Profile Page
    And I look at the SQL Score Breakdown on the Trainee Profile Page
    Then I see the specific SQL score breakdown of "Bill Bird" on the Trainee Profile Page

    # Scenario for Specific Not SQL Results using toggle

  Scenario: Can see a breakdown of Not SQL Results on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click on the toggle Not SQL breakdown button on the Trainee Profile Page
    And I look at the Not SQL Breakdown on the Trainee Profile Page
    Then I see the specific Not SQL score breakdown of "Bill Bird" on the Trainee Profile Page

    # Scenarios for Navigation without using Sidebar

  Scenario: Can navigate to Weekly Attendance on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click on Attendance Details on the Trainee Profile Page
    Then I am taken to the Weekly Attendance Page from the Trainee Profile Page

  Scenario: Can navigate to Report Trainer on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click on Report Details on the Trainee Profile Page
    Then I am taken to the Report Trainer Page from the Trainee Profile Page

  Scenario: Can navigate to Home Trainer Page via Back to Dashboard on the Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click on Back to Dashboard on the Trainee Profile Page
    Then I am taken to the Home Trainer Page from the Trainee Profile Page

    # Scenarios for Navigation using Sidebar

  Scenario: Trainer goes to Consultancy Skills page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click View on the trainer sidebar on the Trainee Profile Page
    And I click on Consultancy Skills on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Consultancy Skills Page from the Trainee Profile Page

  Scenario: Trainer goes to Trainee Guide page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click View on the trainer sidebar on the Trainee Profile Page
    And I click on Trainee Guide on the trainer sidebar the Trainee Profile Page
    Then I am taken to the Trainee Guide Page from the Trainee Profile Page

  Scenario: Trainer goes to Class Management page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Class Management on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Class Management Page from the Trainee Profile Page

  Scenario: Trainer goes to Manage Trainee page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Trainee Management on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Manage Trainee Page from the Trainee Profile Page

  Scenario: Trainer goes to Add Weeks page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Add Weeks on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Add Weeks Page from the Trainee Profile Page

  Scenario: Trainer goes to Assessments page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Assessments on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Assessments Page from the Trainee Profile Page

  Scenario: Trainer goes to Enter Attendance page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Enter Attendance on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Enter Attendance Page from the Trainee Profile Page

  Scenario: Trainer goes to Weekly Attendance page from Trainee Profile Page
    Given I am logged in as a trainer and on the Trainee Profile Page of "Bill Bird"
    When I click Trainer Options on the trainer sidebar on the Trainee Profile Page
    And I click on Weekly Attendance on the trainer sidebar on the Trainee Profile Page
    Then I am taken to the Weekly Attendance Page from the Trainee Profile Page
