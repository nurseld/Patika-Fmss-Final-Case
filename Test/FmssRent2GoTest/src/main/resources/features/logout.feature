Feature: Logout Functionality for Individual and Corporate Customers

  @appium
  Background: User is on the "Profile" screen
    Given User opens the app

  Scenario: Successful logout for individual customer
    Given User should be logged in as an Individual customer
    When User clicks the "logout" button
    Then User should be redirected to the "login" screen

  Scenario: Successful logout for corporate customer
    Given User should be logged in as an Individual customer
    When User clicks the "logout" button
    Then User should be redirected to the "login" screen