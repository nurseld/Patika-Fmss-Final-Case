Feature: Rent2Go Login screen functionality verification

  @appium
  Background:
    Given User opens the app

  Scenario: Successful login with valid email and password as an Individual customer
    And User clicks the "Individual" button
    And User fills email as "individual@example.com"
    And User fills password as "individualpass"
    And User clicks the login button
    Then User should be logged in as an Individual customer

  Scenario: Successful login with valid email and password as an Corporate customer
    And User clicks the "Corporate" button
    And User fills email as "corporate@example.com"
    And User fills password as "corporatepass"
    And User clicks the login button
    Then User should be logged in as an Individual customer

  Scenario: Navigate to Sign Up screen
    When User clicks the Sign Up button
    Then User should be on the Sign Up screen

  Scenario: Use the app as a Guest user
    When User clicks the Guest User button
    Then User should be able to use the app as a guest

  Scenario: Forgot Password - Reset Password
    When User clicks the "Forgot Password" link
    And User fills email as "user@example.com"
    And User clicks the "Send Reset Link" button
    Then User should see "reset link has been sent to their email" confirmation massage

  Scenario: Forgot Password - Email not registered
    When User clicks the "Forgot Password" link
    And User fills email as "notregistered@example.com"
    And User clicks the "Send Reset Link" button
    Then User should see "email is not registered" error meesage

  Scenario: Failed login with incorrect password for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as "corporate@example.com"
    And User fills password as "wrongcorporatepass"
    And User clicks the login button
    Then User should see "incorrect password" error meesage


  Scenario: Failed login with incorrect email for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as "wrongcorporate@example.com"
    And User fills password as "corporatepass"
    And User clicks the login button
    Then User should see "incorrect email" error meesage


  Scenario: Failed login with incorrect password for Individual customer
    And User clicks the "Individual" button
    And User fills email as "individual@example.com"
    And User fills password as "wrongindividualpass"
    And User clicks the login button
    Then User should see "incorrect password" error meesage


  Scenario: Failed login with incorrect email for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as "wrongcorporate@example.com"
    And User fills password as "corporatepass"
    And User clicks the login button
    Then User should see "incorrect email" error meesage


  Scenario: Leaving the email field empty for Individual customer
    And User clicks the "Individual" button
    And User fills email as ""
    And User fills password as "password123"
    And User clicks the login button
    Then User should see "Email is required" error meesage


  Scenario: Leaving the password field empty for Individual customer
    And User clicks the "Individual" button
    And User fills email as "user@example.com"
    And User fills password as ""
    And User clicks the login button
    Then User should see "Password is required" error meesage


  Scenario: Leaving both email and password fields empty for Individual customer
    And User clicks the "Individual" button
    And User fills email as ""
    And User fills password as ""
    And User clicks the login button
    Then User should see "Email and password are required" error meesage


  Scenario: Leaving the email field empty for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as ""
    And User fills password as "corporatepass"
    And User clicks the login button
    Then User should see "Email is required" error meesage


  Scenario: Leaving the password field empty for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as "corporate@example.com"
    And User fills password as ""
    And User clicks the login button
    Then User should see "Password is required" error meesage


  Scenario: Leaving both email and password fields empty for Corporate customer
    And User clicks the "Corporate" button
    And User fills email as ""
    And User fills password as ""
    And User clicks the login button
    Then User should see "Email and password are required" error meesage
