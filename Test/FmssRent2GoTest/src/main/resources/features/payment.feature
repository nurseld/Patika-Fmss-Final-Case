Feature: Payment functionality verification


  Background: User opens the app

  Scenario: Successful payment during reservation for Individual customer
    Given User has selected a vehicle and entered reservation details
    When User enters valid credit card information
    And User clicks the "Submit Payment" button
    Then User should see a payment confirmation message


  Scenario: Failed payment during reservation for Individual customer due to invalid card details
    Given User has selected a vehicle and entered reservation details
    When User enters invalid credit card information
    And User clicks the "Submit Payment" button
    Then User should see an error message "Payment failed: Invalid card details"