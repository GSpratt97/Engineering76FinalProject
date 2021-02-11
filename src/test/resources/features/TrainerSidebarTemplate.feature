# new feature
# Tags: optional

Scenario: Trainer goes to Consultancy Skills page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click View on the trainer sidebar
And I click on Consultancy Skills
Then I am taken to the Consultancy Skills page from Home Trainer page

Scenario: Trainer goes to Trainee Guide page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click View on the trainer sidebar
And I click on Trainee Guide
Then I am taken to the Trainee Guide page from Home Trainer page

Scenario: Trainer goes to Class Management page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Class Management
Then I am taken to the Class Management page from Home Trainer page

Scenario: Trainer goes to Manage Trainee page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Trainee Management
Then I am taken to the Manage Trainee page from Home Trainer page

Scenario: Trainer goes to Add Weeks page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Add Weeks
Then I am taken to the Add Weeks page from Home Trainer page

Scenario: Trainer goes to Assessments page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Assessments
Then I am taken to the Add Weeks page from Home Trainer page

Scenario: Trainer goes to Enter Attendance page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Enter Attendance
Then I am taken to the Enter Attendance page from Home Trainer page

Scenario: Trainer goes to Weekly Attendance page from Home Trainer page
Given I am logged in as a trainer and I am on the Home Trainer page
When I click Trainer Options on the trainer sidebar
And I click on Weekly Attendance
Then I am taken to the Weekly Attendance page from Home Trainer page