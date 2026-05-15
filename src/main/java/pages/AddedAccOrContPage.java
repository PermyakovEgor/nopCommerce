package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddedAccOrContPage extends BasePage{

    public AddedAccOrContPage(WebDriver driver) {
        super(driver);
    }

    private final By MODULE_TITLE_TEXT = By.xpath("//h2[@class='module-title-text']");

    @Override
    public AddedAccOrContPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODULE_TITLE_TEXT));
        return this;
    }

    public String saveContact() {
        isPageOpened();
        WebElement contact = driver.findElement(MODULE_TITLE_TEXT);
        String text = contact.getText();
        return text;
    }
}
