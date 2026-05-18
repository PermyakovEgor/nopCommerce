package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

@Log4j2
public class CreateAccPage extends BasePage{

    public CreateAccPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public CreateAccPage inputWrite(String name, String phone, String fax, String webSite) {
        log.info("Adding input new account with name '{}'", name);
        new Input(driver, "Name").write(name);
        new Input(driver, "Office Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(webSite);
        return this;
    }

    public CreateAccPage addressTextareaWrite(String street1, String street2) {
        log.info("Adding textarea address new account with street: '{}' and '{}'", street1, street2);
        new AddressTextarea(driver, "Billing Address", "Street").write(street1);
        new AddressTextarea(driver, "Shipping Address", "Street").write(street2);
        return this;
    }

    public CreateAccPage payAddressInputWrite(String city, String state, String postalCode, String country) {
        log.info("Adding input new account pay address city: '{}'", city);
        new AddressInput(driver, "Billing Address", "City").write(city);
        new AddressInput(driver, "Billing Address", "State/Region").write(state);
        new AddressInput(driver, "Billing Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Billing Address", "Country").write(country);
        return this;
    }

    public CreateAccPage liveAddressInputWrite(String city, String state, String postalCode, String country) {
        log.info("Adding input new account live address city: '{}'", city);
        new AddressInput(driver, "Shipping Address", "City").write(city);
        new AddressInput(driver, "Shipping Address", "State/Region").write(state);
        new AddressInput(driver, "Shipping Address", "Postal Code").write(postalCode);
        new AddressInput(driver, "Shipping Address", "Country").write(country);
        return this;
    }

    public CreateAccPage addressTextareaDescription(String description) {
        log.info("Adding textarea new account description: '{}'", description);
        new Textarea(driver, "description").writeDescription(description);
        return this;
    }

    public CreateAccPage selectChoiceOption(String option1, String option2) {
        log.info("Selecting option new account: '{}' and '{}'", option1, option2);
        new Select(driver, "Type").select(option1);
        new Select(driver, "Industry").select(option2);
        return this;
    }

    public AddedAccOrContPage clickSave() {
        log.info("Click SaveButton and save new account");
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new AddedAccOrContPage(driver);
    }
}
