Feature:  Car search functionality verification

  @appium
  Background: User opens the app


  Scenario: Vehicle search without registration
    Given User is on the home screen without logging in
    When User navigates to the cars page
    And User enters pickup location as "Istanbul"
    And User enters pickup and drop-off dates
    And User clicks the "Search" button
    Then User should see a list of available vehicles matching the criteria


  Scenario: Vehicle search with filters
    Given User navigates to the cars page
    When User applies filters for 'brand', 'model' and 'price'
    Then User should see a filtered list of vehicles