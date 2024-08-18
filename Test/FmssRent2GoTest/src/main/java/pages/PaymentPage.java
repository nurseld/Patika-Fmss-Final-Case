package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PaymentPage {
    private AppiumDriver<MobileElement> driver;

    public PaymentPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By cardNumberField = By.id("card_number_id");
    private By cvvField = By.id("cvv_id");
    private By completePaymentButton = By.id("complete_payment_button_id");
    private By paymentConfirmationMessage = By.id("payment_confirmation_message_id");
    private By paymentErrorMessage = By.id("payment_error_message_id");



    public void enterCardDetails(String cardNumber, String cvv) {
        try {
            MobileElement cardField = driver.findElement(cardNumberField);
            MobileElement cvvFieldElement = driver.findElement(cvvField);

            cardField.clear();
            cardField.sendKeys(cardNumber);

            cvvFieldElement.clear();
            cvvFieldElement.sendKeys(cvv);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Payment fields not found");
        }
    }

    public void completePayment() {
        try {
            driver.findElement(completePaymentButton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Complete payment button not found");
        }
    }


    public boolean isPaymentConfirmationDisplayed() {
        try {
            return driver.findElement(paymentConfirmationMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public String getPaymentErrorMessage() {
        try {
            return driver.findElement(paymentErrorMessage).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }


}
