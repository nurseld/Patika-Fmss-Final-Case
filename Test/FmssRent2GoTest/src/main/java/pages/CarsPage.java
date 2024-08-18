package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CarsPage {

    private AppiumDriver<MobileElement> driver;

    public CarsPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    private final By carsPageButton = By.id("carsPageButton_id");
    private final By pickupLocationField = By.id("pickupLocationField_id");
    private final By pickupDateField = By.id("pickupDateField_id");
    private final By dropOffDateField = By.id("dropOffDateField_id");
    private final By searchButton = By.id("searchButton_id");
    private final By vehicleList = By.id("vehicleList_id");
    private final By brandFilter = By.id("brandFilter_id");
    private final By modelFilter = By.id("modelFilter_id");
    private final By priceTypeFilter = By.id("priceTypeFilter_id");
    private final By filteredVehicleList = By.id("filteredVehicleList_id");
    private final By searchResultsPage = By.id("searchResultsPage_id");


    public void clickCarsPageButton() {
        driver.findElement(carsPageButton).click();
    }


    public void enterPickupLocation(String location) {
        MobileElement locationField = driver.findElement(pickupLocationField);
        locationField.clear();
        locationField.sendKeys(location);
    }


    public void selectPickupDate() {
        MobileElement dateField = driver.findElement(pickupDateField);
        dateField.clear();
        CharSequence pickupDate = null;
        dateField.sendKeys(pickupDate);
    }

    public void selectDropOffDate() {
        MobileElement dateField = driver.findElement(dropOffDateField);
        dateField.clear();
        CharSequence dropOffDate = null;
        dateField.sendKeys(dropOffDate);
    }


    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }


    public boolean isVehicleListDisplayed() {
        try {
            return driver.findElement(vehicleList).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void applyFilter(String brand, String model, String priceType) {
        MobileElement brandField = driver.findElement(brandFilter);
        brandField.clear();
        brandField.sendKeys(brand);


        MobileElement modelField = driver.findElement(modelFilter);
        modelField.clear();
        modelField.sendKeys(model);


        MobileElement priceTypeField = driver.findElement(priceTypeFilter);
        priceTypeField.clear();
        priceTypeField.sendKeys(priceType);


        clickSearchButton();
    }

    public boolean isFilteredVehicleListDisplayed() {
        try {
            return driver.findElement(filteredVehicleList).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchResultsPageDisplayed() {
        try {
            return driver.findElement(searchResultsPage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}