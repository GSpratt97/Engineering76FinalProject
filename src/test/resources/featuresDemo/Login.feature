Feature: Login to the website

#  Scenario: Logging in as trainer
#    Given I am on the login page
#    When I log in with trainer email and password
#    Then I am taken to the trainer home page from the login page
#
#  Scenario: Logging in as trainee
#    Given I am on the login page
#    When I log in with trainee email and password
#    Then I am taken to the trainee home page from the login page
#
#  Scenario: Wrong details fails login
#    Given I am on the login page
#    When I log in with incorrect email and password
#    Then I am taken to the login error page from the login page

  Scenario: Logging in as a trainer
    Given I am on the login page
    When I log in with trainer email and password
    Then I am taken to the trainer home page from the login page

  Scenario: Logging in as a trainer on mobile
    Given I am on the login page on mobile
    When I log in with trainer email and password
    Then I am taken to the trainer home page from the login page
    #Have this version not quit!!


