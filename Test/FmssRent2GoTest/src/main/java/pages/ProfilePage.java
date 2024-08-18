package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ProfilePage {

    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;

    public ProfilePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }


    private By logoutButton = By.id("logoutButton_id");
    private By profileSettingsOption = By.id("profile_settings_id");
    private By complaintsOption = By.id("complaints_id");
    private By branchListOption = By.id("branch_list_id");
    private By notificationSettingsOption = By.id("notification_settings_id");
    private By contactOption = By.id("contact_id");
    private By termsOfUseOption = By.id("terms_of_use_id");
    private By corporationRentalListOption = By.id("corporation_rental_list_id");
    private By welcomeMessage = By.id("welcome_message_id");
    private By phoneNumberField = By.id("phone_number_id");
    private By companyContactNameField = By.id("company_contact_name_id");
    private By confirmationMessage = By.id("confirmation_message_id");
    private By previousReservationsList = By.id("previous_reservations_list_id");
    private By saveButton = By.id("save_button_id");
    private By cancelButton = By.id("cancel_button_id");
    private By invoicesSection = By.id("invoices_section_id");
    private By reservationList = By.id("reservation_list_id");
    private By invoiceDetails = By.id("invoice_details_id");
    private By downloadInvoiceButton = By.id("download_invoice_button_id");
    private By activeReservationLocator = By.id("active_reservation_id");




    public void clickProfileSettings() {
        driver.findElement(profileSettingsOption).click();
    }

    public void clickComplaints() {
        driver.findElement(complaintsOption).click();
    }

    public void clickBranchList() {
        driver.findElement(branchListOption).click();
    }

    public void clickNotificationSettings() {
        driver.findElement(notificationSettingsOption).click();
    }

    public void clickContact() {
        driver.findElement(contactOption).click();
    }

    public void clickTermsOfUse() {
        driver.findElement(termsOfUseOption).click();
    }

    public void clickCorporationRentalList() {
        driver.findElement(corporationRentalListOption).click();
    }


    public boolean isUserLoggedIn() {
        try {
            return driver.findElement(logoutButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            return driver.findElement(welcomeMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }


    public boolean isLoginScreenDisplayed() {
        return loginPage.isLoginScreenDisplayed();
    }


    public void updatePhoneNumber(String phoneNumber) {
        MobileElement phoneNumberFieldElement = driver.findElement(phoneNumberField);
        phoneNumberFieldElement.clear();
        phoneNumberFieldElement.sendKeys(phoneNumber);
    }


    public void updateCompanyContactName(String contactName) {
        MobileElement contactNameFieldElement = driver.findElement(companyContactNameField);
        contactNameFieldElement.clear();
        contactNameFieldElement.sendKeys(contactName);
    }


    public String getConfirmationMessage() {
        try {
            return driver.findElement(confirmationMessage).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    public boolean isPreviousReservationsListDisplayed() {
        try {
            return driver.findElement(previousReservationsList).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();

    }
    public void navigateToInvoicesSection() {
        driver.findElement(invoicesSection).click();
    }

    public boolean hasCompletedReservation() {
        try {
            return driver.findElement(activeReservationLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void selectReservation(String reservationId) {
        try {

            MobileElement reservationListElement = driver.findElement(reservationList);
            if (reservationListElement.isDisplayed()) {
                By reservationLocator = By.id("reservation_" + reservationId);
                driver.findElement(reservationLocator).click();
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Reservation list or reservation not found");
        }
    }


    public boolean isInvoiceDetailsDisplayed() {
        try {
            return driver.findElement(invoiceDetails).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void downloadInvoiceAsPDF() {
        driver.findElement(downloadInvoiceButton).click();
    }




}
