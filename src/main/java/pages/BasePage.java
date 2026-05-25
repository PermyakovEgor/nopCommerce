package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public final String BASE_URL = "https://demo.suiteondemand.com/index.php?module=Users&action=Login";
    public final String CREATE_ACC_PAGE_URL = "https://demo.suiteondemand.com/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView";
    public final  String CREATE_CONTACT_PAGE_URL = "https://demo.suiteondemand.com/index.php?module=Contacts&action=EditView&return_module=Contacts&return_action=DetailView";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public abstract BasePage isPageOpened();
}
