package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HomePage extends BasePage{

    private final By CREATE_ACC_PAGE = By.xpath("//div[contains(text(), 'Name')]");
    private final By CREATE_CONT_PAGE = By.xpath("//div[contains(text(), 'First Name')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    //Не особо понимаю как мне использовать этот метод, если я с этой страницы перехожу на 2 разных страницы и жду там
    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public CreateAccPage openCreateAccPage() {
        log.info("Open create account page");
        driver.get(CREATE_ACC_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_ACC_PAGE));
        return new CreateAccPage(driver);
    }

    public CreateContactPage openCreateContPage() {
        log.info("Open create contact page");
        driver.get(CREATE_CONTACT_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_CONT_PAGE));
        return new CreateContactPage(driver);
    }
}
