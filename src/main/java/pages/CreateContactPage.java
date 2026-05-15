package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.*;

public class CreateContactPage extends BasePage{

    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public CreateContactPage inputWriteContact(Account account) {
        new Input(driver, "First Name").write(account.getFirstName());
        new Input(driver, "Last Name").write(account.getLastName());
        new Input(driver, "Office Phone").write(account.getOfficePhone());
        new Input(driver, "Mobile").write(account.getMobilePhone());
        new Input(driver, "Job Title").write(account.getTitle());
        new Input(driver, "Department").write(account.getDepartment());
        new Input(driver, "Fax").write(account.getFax());
        new AddressInput(driver, "Primary Address", "City").write(account.getCity());
        new AddressInput(driver, "Primary Address", "State/Region").write(account.getState());
        new AddressInput(driver, "Primary Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Primary Address", "Country").write(account.getCountry());
        return this;
    }

    public CreateContactPage textareaWriteContact(String street, String description) {
        new AddressTextarea(driver, "Primary Address", "Address").write(street);
        new Textarea(driver, "description").writeDescription(description);
        return this;
    }

    public CreateContactPage selectCheckboxContact() {
        new Checkbox(driver,  "Copy address from left:").selectCheckbox();
        return this;
    }

    public AddedAccOrContPage clickSave() {
        WebElement saveButton = driver.findElement(By.id("SAVE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        return new AddedAccOrContPage(driver);
    }
}
