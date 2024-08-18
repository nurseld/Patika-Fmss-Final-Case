Feature: Invoice section functionality verification

  @appium
  Background: User opens the app

  Scenario: Viewing and downloading invoice for Individual customer
    When User navigates to the "Invoices" section in their profile
    And User selects the reservation for which the invoice is needed
    Then User should be able to view the invoice with details
    And User should be able to download the invoice as a PDF


  Scenario: Viewing and downloading invoice for Corporate customer
    When Corporate user navigates to the "Invoices" section in their profile
    And Corporate user selects the reservation for which the invoice is needed
    Then Corporate user should be able to view the invoice with details
    And Corporate user should be able to download the invoice as a PDF