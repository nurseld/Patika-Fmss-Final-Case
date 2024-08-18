Feature: Reservation functionality verification


  Background:
    Given User opens the app


  Scenario: Successful reservation by Individual customer
    Given User should be logged in as an Individual customer
    When User navigates to the reservation page
    And User selects pickup and drop-off dates and location
    And User selects a vehicle
    And navigate to payment page
    Then User should see a reservation confirmation with details

  Scenario: Successful reservation by Corporate customer
    Given User should be logged in as a Corporate customer
    When Corporate user navigates to the reservation page
    And Corporate user selects pickup and drop-off dates and location
    And User selects a vehicle
    And navigate to payment page
    Then Corporate user should see a reservation confirmation with details

  Scenario: Successful reservation cancellation by Individual customer
    When User navigates to the reservation details page
    And User clicks the "Cancel Reservation" button
    Then User should see a confirmation message "Your reservation has been successfully cancelled"
