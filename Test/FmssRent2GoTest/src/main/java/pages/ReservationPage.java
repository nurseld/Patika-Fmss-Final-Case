package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ReservationPage {

    private AppiumDriver<MobileElement> driver;

    public ReservationPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    private By reservationPageButton = By.id("reservation_page_id");
    private By pickupDateField = By.id("pickup_date_id");
    private By dropOffDateField = By.id("dropoff_date_id");
    private By locationField = By.id("location_field_id");
    private By vehicleSelectButton = By.id("vehicle_select_id");
    private By paymentButton = By.id("payment_button_id");
    private By reservationConfirmation = By.id("reservation_confirmation_id");
    private By reservationDetailsButton = By.id("reservation_details_id");
    private By confirmationMessage = By.id("confirmation_message_id");
    private By navigateToPaymentPageButton = By.id("navigate_to_payment_page_button_id");


    public void navigateToReservationPage() {
        try {
            driver.findElement(reservationPageButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Reservation page button not found");
        }
    }

    public void selectPickupAndDropOffDates(String pickupDate, String dropOffDate) {
        try {
            driver.findElement(pickupDateField).clear();
            driver.findElement(pickupDateField).sendKeys(pickupDate);

            driver.findElement(dropOffDateField).clear();
            driver.findElement(dropOffDateField).sendKeys(dropOffDate);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Date fields not found");
        }
    }

    public void selectLocation(String location) {
        try {
            driver.findElement(locationField).clear();
            driver.findElement(locationField).sendKeys(location);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Location field not found");
        }
    }

    public void selectVehicleAndCompletePayment() {
        try {
            driver.findElement(vehicleSelectButton).click();
            driver.findElement(paymentButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Vehicle selection or payment button not found");
        }
    }

    public boolean isReservationConfirmationDisplayed() {
        try {
            return driver.findElement(reservationConfirmation).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void navigateToReservationDetailsPage() {
        try {
            driver.findElement(reservationDetailsButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Reservation details button not found");
        }
    }

    public String getConfirmationMessage() {
        try {
            return driver.findElement(confirmationMessage).getText();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Confirmation message not found");
        }
    }

    public void selectVehicle() {
        try {
            driver.findElement(vehicleSelectButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Vehicle select button not found");
        }
    }

    public void navigateToPaymentPage() {
        try {
            driver.findElement(navigateToPaymentPageButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Navigate to payment page button not found");
        }
    }
}