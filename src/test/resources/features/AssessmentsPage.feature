Feature: Actions on the Assessments Page


  Scenario: Clicking Trainee Bill Bird
    Given I am logged in as a trainer and on the Assessments Page
    When I click on a Trainee called "Bill Bird" on the Assessments Page
    Then I am taken to the Assessments Breakdown Page from the Assessments Page

  Scenario: Clicking Trainee David Trieu
    Given I am logged in as a trainer and on the Assessments Page
    When I click on a Trainee called "David Trieu" on the Assessments Page
    Then I am taken to the Assessments Breakdown Page from the Assessments Page

  Scenario: Trainer goes to Consultancy Skills page from Assessments Page page
    Given I am logged in as a trainer and on the Assessments Page
    When I click View on the trainer sidebar on the Assessments Page
    And I click on Consultancy Skills on the trainer sidebar on the Assessments Page
    Then I am taken to the Consultancy Skills Page from the Assessments Page

  Scenario: Trainer goes to Trainee Guide page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click View on the trainer sidebar on the Assessments Page
    And I click on Trainee Guide on the trainer sidebar the Assessments Page
    Then I am taken to the Trainee Guide Page from the Assessments Page

  Scenario: Trainer goes to Class Management page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Class Management on the trainer sidebar on the Assessments Page
    Then I am taken to the Class Management Page from the Assessments Page

  Scenario: Trainer goes to Manage Trainee page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Trainee Management on the trainer sidebar on the Assessments Page
    Then I am taken to the Manage Trainee Page from the Assessments Page

  Scenario: Trainer goes to Add Weeks page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Add Weeks on the trainer sidebar on the Assessments Page
    Then I am taken to the Add Weeks Page from the Assessments Page

  Scenario: Trainer goes to Assessments page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Assessments on the trainer sidebar on the Assessments Page
    Then I am taken to the Assessments Page from the Assessments Page

  Scenario: Trainer goes to Enter Attendance page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Enter Attendance on the trainer sidebar on the Assessments Page
    Then I am taken to the Enter Attendance Page from the Assessments Page

  Scenario: Trainer goes to Weekly Attendance page from Home Trainer page
    Given I am logged in as a trainer and on the Assessments Page
    When I click Trainer Options on the trainer sidebar on the Assessments Page
    And I click on Weekly Attendance on the trainer sidebar on the Assessments Page
    Then I am taken to the Weekly Attendance Page from the Assessments Page

