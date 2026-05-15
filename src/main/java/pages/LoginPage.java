package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    private final By LOGIN_PAGE = By.id("bigbutton");
    private final By USER_NAME = By.id("user_name");
    private final By PASSWORD = By.id("username_password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE));
        return this;
    }

    public HomePage login(String user, String password) {
        isPageOpened();
        driver.findElement(USER_NAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_PAGE).click();
        return new HomePage(driver);
    }
}
