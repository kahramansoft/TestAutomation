@login_feature
Feature: Login Feature

  Scenario: Success login
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter valid email on login page
    And Enter valid password on login page
    When Click login button on login page
    And Hover my account button on home page
    Then User should be successfully logged in home page

  Scenario: Fail login with invalid password
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter valid email on login page
    And Enter invalid password on login page
    When Click login button on login page
    Then User should encounter a login failure on the login page

  Scenario: Fail login with invalid email
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter invalid email on login page
    And Enter valid password on login page
    When Click login button on login page
    Then User should encounter a login failure on the login page with wrong email

  Scenario: Fail login with invalid email characters
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter invalid characters email on login page
    And Enter valid password on login page
    When Click login button on login page
    Then User should encounter a login failure on the login page with wrong email characters

  Scenario: Fail login with empty user
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter empty user on login page
    And Enter valid password on login page
    When Click login button on login page
    Then User should encounter a login failure on the login page with empty username

  Scenario: Fail login with empty password
    Given Navigate to the home page
    And Click cookies accept button on home page
    And Click login button on home page
    And Enter valid email on login page
    And Enter empty password on login page
    When Click login button on login page
    Then User should encounter a login failure on the login page with empty password