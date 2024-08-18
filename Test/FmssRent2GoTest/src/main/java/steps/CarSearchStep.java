package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarsPage;
import utils.DriverManager;

public class CarSearchStep {

    private AppiumDriver<MobileElement> driver;
    private CarsPage carsPage;

    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    public CarSearchStep() {
        this.driver = DriverManager.getDriver();
        this.carsPage = new CarsPage(driver);
    }

    @Given("User is on the home screen without logging in")
    public void userIsOnTheHomeScreenWithoutLoggingIn() {
        assert carsPage.isVehicleListDisplayed() : "Home screen is not displayed or user is already logged in";
    }

    @When("User navigates to the cars page")
    public void userNavigatesToTheCarsPage() {
        carsPage.clickCarsPageButton();
    }

    @And("User enters pickup location as {string}")
    public void userEntersPickupLocationAs(String location) {
        carsPage.enterPickupLocation(location);
    }

    @And("User enters pickup and drop-off dates")
    public void userEntersPickupAndDropOffDates() {
        carsPage.selectPickupDate();
        carsPage.selectDropOffDate();
    }

    @Then("User should see a list of available vehicles matching the criteria")
    public void userShouldSeeAListOfAvailableVehiclesMatchingTheCriteria() {
        assert carsPage.isVehicleListDisplayed() : "No available vehicles matching the criteria were found";
    }

    @Given("User is on the vehicle search results page")
    public void userIsOnTheVehicleSearchResultsPage() {
        assert carsPage.isSearchResultsPageDisplayed() : "Vehicle search results page is not displayed";
    }

    @When("User applies filters for {string}, {string} and {string}")
    public void userAppliesFiltersForBrandModelAndPrice(String brand, String model, String priceType) {
        carsPage.applyFilter(brand, model, priceType);
    }

    @Then("User should see a filtered list of vehicles")
    public void userShouldSeeAFilteredListOfVehicles() {
        assert carsPage.isFilteredVehicleListDisplayed() : "Filtered list of vehicles is not displayed";
    }

}
