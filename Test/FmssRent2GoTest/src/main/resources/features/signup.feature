Feature: Signup Process for Individual and Corporate Customers

  @appium
  Background: User opens the app
    Given User opens the app

  Scenario: Successful signup for individual customer
    When user clicks the "individual" button
    And user clicks the "signup" button
    And user enters "12345678901" as identity number
    And user enters "John" as first name
    And user enters "Doe" as last name
    And user selects "01/01/1990" as birthdate
    And user selects "Male" as gender
    And user clicks the "next" button
    And user enters "johndoe@example.com" as email
    And user enters "+123456789" as phone number
    And user enters "Password123!" as password
    And user confirms "Password123!" as password
    And user clicks the "next" button
    And user enters "D1234567" as drivers license id
    And user enters "New York" as place to purchase driving license
    And user selects "01/01/2020" as date of taking license
    And user selects "B" as driving license group
    And user agrees to the user agreement
    And user clicks the "signup submit" button
    Then user should be successfully registered

  Scenario: Successful signup for corporate customer
    When user clicks the "corporate" button
    And user clicks the "signup" button
    And user enters "11111111111" as tax number
    And user enters "ABC Corp." as company name
    And user enters "John Doe" as contact name
    And user clicks the "next" button
    And user enters "corp@example.com" as email
    And user enters "+987654321" as phone number
    And user enters "Password456!" as password
    And user confirms "Password456!" as password
    And user agrees to the user agreement
    And user clicks the "signup submit" button
    Then user should be successfully registered

  Scenario: Individual user fails to complete signup due to missing mandatory fields
    When user clicks the "individual" button
    And user clicks the "signup" button without filling any fields
    Then user should see validation errors for mandatory fields
    And the error message should say "Please fill in all fields."

  Scenario: Corporate user fails to complete signup due to missing user agreement
    When user clicks the "corporate" button
    And user fills all fields correctly
    And user clicks the "signup" button
    Then user should see an error message for user agreement
    And the error message should say "You must agree to the user agreement."

  Scenario: Individual user fails signup due to mismatched passwords
    When user clicks the "individual" button
    And user enters valid information in all fields
    And user enters "Password123!" as password
    And user confirms "Password1234!" as password
    And user clicks the "signup submit" button
    Then user should see a password mismatch error
    And the error message should say "Passwords do not match."

  Scenario: Corporate user fails signup due to invalid email format
    When user clicks the "corporate" button
    And user enters valid information in all fields
    And user enters "invalid-email-format" as email
    And user clicks the "signup submit" button
    Then user should see an invalid email format error
    And the error message should say "Please enter a valid email address."

  Scenario: Individual user fails signup due to weak password
    When user clicks the "individual" button
    And user enters valid information in all fields
    And user enters "12345" as password
    And user confirms "12345" as password
    And user clicks the "signup submit" button
    Then user should see a weak password error
    And the error message should say "Password is too weak. Please use a stronger password."

  Scenario: Corporate user fails signup due to missing phone number
    When user clicks the "corporate" button
    And user enters valid information in all fields
    And user leaves the phone number field blank
    And user clicks the "signup submit" button
    Then user should see a phone number required error