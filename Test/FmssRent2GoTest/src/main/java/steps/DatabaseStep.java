package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatabaseStep {


    @Given("The database is set up correctly")
    public void theDataBaseIsSetUpCorrectly(){}

    @When("the user queries the {string} table schema")
    public void theUserQueriesTheUsersTableSchema() {
    }

    @Then("the {string} column should exist with data type {string}")
    public void theIdColumnShouldExistWithDataTypeInteger() {
    }

    @When("the user queries the primary key in {string} table")
    public void theUserQueriesThePrimaryKeyInUsersTable() {
    }

    @Then("the {string} column should be the primary key in the {string} table")
    public void theIdColumnShouldBeThePrimaryKeyInTheUsersTable() {
    }

    @When("the user queries the unique constraint on {string} column in {string} table")
    public void theUserQueriesTheUniqueConstraintOnEmailColumnInUsersTable() {
    }

    @Then("the {string} column should have a unique constraint")
    public void theEmailColumnShouldHaveAUniqueConstraint() {
    }

    @When("the user queries the {string} and {string} columns in {string}")
    public void theUserQueriesTheFirst_nameAndLast_nameColumnsInIndividual_customers() {
    }

    @Then("the {string} column should not allow null values")
    public void theFirst_nameColumnShouldNotAllowNullValues() {
    }

    @When("the user queries the foreign key relationship between {string} and {string}")
    public void theUserQueriesTheForeignKeyRelationshipBetweenIndividual_customersAndUsers() {
    }

    @Then("the {string} in {string} should reference {string} in {string}")
    public void theUser_idInIndividual_customersShouldReferenceIdInUsers() {
    }
}
