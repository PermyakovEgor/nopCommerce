package pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.*;

@Log4j2
public class CreateContactPage extends BasePage{

    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public CreateContactPage inputWriteContact(Account account) {
        log.info("Adding input new contact with name '{}'", account.getFirstName());
        new Input(driver, "First Name").write(account.getFirstName());
        new Input(driver, "Last Name").write(account.getLastName());
        new Input(driver, "Office Phone").write(account.getOfficePhone());
        new Input(driver, "Mobile").write(account.getMobilePhone());
        new Input(driver, "Job Title").write(account.getTitle());
        new Input(driver, "Department").write(account.getDepartment());
        new Input(driver, "Fax").write(String.valueOf(account.getFax()));
        new AddressInput(driver, "Primary Address", "City").write(account.getCity());
        new AddressInput(driver, "Primary Address", "State/Region").write(account.getState());
        new AddressInput(driver, "Primary Address", "Postal Code").write(String.valueOf(account.getFax()));
        new AddressInput(driver, "Primary Address", "Country").write(account.getCountry());
        return this;
    }

    public CreateContactPage textareaWriteContact(String street, String description) {
        log.info("Adding textarea new contact street: '{}' and description: '{}'", street, description);
        new AddressTextarea(driver, "Primary Address", "Address").write(street);
        new Textarea(driver, "description").writeDescription(description);
        return this;
    }

    public CreateContactPage selectCheckboxContact() {
        log.info("Selecting checkbox copy address new contact");
        new Checkbox(driver,  "Copy address from left:").selectCheckbox();
        return this;
    }

    public AddedAccOrContPage clickSave() {
        log.info("Click SaveButton and save new contact");
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new AddedAccOrContPage(driver);
    }
}
