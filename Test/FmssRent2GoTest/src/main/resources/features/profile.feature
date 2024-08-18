Feature: Profile page functionality verification

  Background: User opens the app


  Scenario: Viewing profile page for Individual customer
    Given User should be logged in as an Individual customer
    When User navigates to the "Profile" page
    Then User should see their personal details


  Scenario: Updating profile details for Individual customer
    Given User should be logged in as an Individual customer
    When User navigates to the "Profile" page
    And User updates their phone number to "+987654321"
    And User clicks the "Save" button
    Then User should see a message "Profile updated successfully"


  Scenario: Viewing profile page for Corporate customer
    Given User should be logged in as a Corporate customer
    When Corporate user navigates to the "Profile" page
    Then Corporate user should see their company details


  Scenario: Updating profile details for Corporate customer
    Given User should be logged in as a Corporate customer
    When Corporate user navigates to the "Profile" page
    And Corporate user updates the company contact name to "Jane Doe"
    And Corporate user clicks the "Save" button
    Then Corporate user should see a message "Profile updated successfully"


  Scenario: Viewing past reservations for Individual customer
    Given User should be logged in as an Individual customer
    When User navigates to the "Past Reservations" section in their profile
    Then User should see a list of their previous reservations


  Scenario: Viewing past reservations for Corporate customer
    Given User should be logged in as a Corporate customer
    When Corporate user navigates to the "Past Reservations" section in their profile
    Then Corporate user should see a list of their previous reservations