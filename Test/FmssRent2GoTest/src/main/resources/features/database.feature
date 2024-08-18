Feature: Verify Database Schema and Foreign Key Integrity

  Background:
    Given The database is set up correctly

  Scenario: Verify 'users' table schema
    When the user queries the 'users' table schema
    Then the 'id' column should exist with data type 'integer'
    And the 'created_date' column should exist with data type 'date'
    And the 'updated_date' column should exist with data type 'date'
    And the 'role' column should exist with data type 'character varying(255)'
    And the 'email' column should exist with data type 'character varying(255)'
    And the 'password' column should exist with data type 'character varying(255)'

  Scenario: Verify primary key in 'users' table
    When the user queries the primary key in 'users' table
    Then the 'id' column should be the primary key in the 'users' table

  Scenario: Verify unique constraint on 'email' column in 'users' table
    When the user queries the unique constraint on 'email' column in 'users' table
    Then the 'email' column should have a unique constraint

  Scenario: Verify 'individual_customers' table schema
    When the user queries the 'individual_customers' table schema
    Then the 'id' column should exist with data type 'integer'
    And the 'first_name' column should exist with data type 'character varying(255)'
    And the 'last_name' column should exist with data type 'character varying(255)'
    And the 'birth_date' column should exist with data type 'date'
    And the 'phone_number' column should exist with data type 'character varying(255)'
    And the 'user_id' column should exist with data type 'integer'

  Scenario: Verify 'first_name' and 'last_name' columns in 'individual_customers' are not nullable
    When the user queries the 'first_name' and 'last_name' columns in 'individual_customers'
    Then the 'first_name' column should not allow null values
    And the 'last_name' column should not allow null values

  Scenario: Verify foreign key relationship between 'individual_customers' and 'users'
    When the user queries the foreign key relationship between 'individual_customers' and 'users'
    Then the 'user_id' in 'individual_customers' should reference 'id' in 'users'

  Scenario: Verify 'corporate_customers' table schema
    When the user queries the 'corporate_customers' table schema
    Then the 'id' column should exist with data type 'integer'
    And the 'company_name' column should exist with data type 'character varying(255)'
    And the 'tax_no' column should exist with data type 'character varying(255)'
    And the 'user_id' column should exist with data type 'integer'

  Scenario: Verify foreign key relationship between 'corporate_customers' and 'users'
    When the user queries the foreign key relationship between 'corporate_customers' and 'users'
    Then the 'user_id' in 'corporate_customers' should reference 'id' in 'users'

  Scenario: Verify 'driver_licenses' table schema
    When the user queries the 'driver_licenses' table schema
    Then the 'license_id' column should exist with data type 'integer'
    And the 'user_id' column should exist with data type 'integer'
    And the 'license_number' column should exist with data type 'character varying'
    And the 'issue_date' column should exist with data type 'date'
    And the 'expiration_date' column should exist with data type 'date'
    And the 'verified' column should exist with data type 'boolean'

  Scenario: Verify foreign key relationship between 'driver_licenses' and 'users'
    When the user queries the foreign key relationship between 'driver_licenses' and 'users'
    Then the 'user_id' in 'driver_licenses' should reference 'id' in 'users'