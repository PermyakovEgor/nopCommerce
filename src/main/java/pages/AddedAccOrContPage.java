package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AddedAccOrContPage extends BasePage{

    public AddedAccOrContPage(WebDriver driver) {
        super(driver);
    }

    private final By MODULE_TITLE_TEXT = By.xpath("//h2[@class='module-title-text']");

    @Override
    public AddedAccOrContPage isPageOpened() {
        log.info("Page where add account or contact is opening");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODULE_TITLE_TEXT));
        return this;
    }

    public String saveContact() {
        log.info("Getting title save contact or account");
        isPageOpened();
        WebElement contact = driver.findElement(MODULE_TITLE_TEXT);
        String text = contact.getText();
        return text;
    }
}
