package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class CreateAccPage extends BasePage{

    public CreateAccPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public CreateAccPage inputWrite(String name, String phone, String fax, String webSite) {
        new Input(driver, "Name").write(name);
        new Input(driver, "Office Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(webSite);
        return this;
    }

    public CreateAccPage addressTextareaWrite(String street1, String street2) {
        new AddressTextarea(driver, "Billing Address", "Street").write(street1);
        new AddressTextarea(driver, "Shipping Address", "Street").write(street2);
        return this;
    }

    public CreateAccPage payAddressInputWrite(String city, String state, String postalCode, String country) {
        new AddressInput(driver, "Billing Address", "City").write(city);
        new AddressInput(driver, "Billing Address", "State/Region").write(state);
        new AddressInput(driver, "Billing Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Billing Address", "Country").write(country);
        return this;
    }

    public CreateAccPage liveAddressInputWrite(String city, String state, String postalCode, String country) {
        new AddressInput(driver, "Shipping Address", "City").write(city);
        new AddressInput(driver, "Shipping Address", "State/Region").write(state);
        new AddressInput(driver, "Shipping Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Shipping Address", "Country").write(country);
        return this;
    }

    public CreateAccPage addressTextareaDescription(String description) {
        new Textarea(driver, "description").writeDescription(description);
        return this;
    }

    public CreateAccPage selectChoiceOption(String option1, String option2) {
        new Select(driver, "Type").select(option1);
        new Select(driver, "Industry").select(option2);
        return this;
    }

    public AddedAccOrContPage clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new AddedAccOrContPage(driver);
    }
}
