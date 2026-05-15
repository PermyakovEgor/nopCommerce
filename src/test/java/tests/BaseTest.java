package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CreateAccPage createAccPage;
    protected CreateContactPage createContactPage;
    protected AddedAccOrContPage addedAccOrContPage;

    @BeforeEach
    @Description("Настройка браузера")
    public void setUp() {
        try {
                ChromeOptions options = new ChromeOptions();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--incognito");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-infobars");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                loginPage = new LoginPage(driver);
                homePage = new HomePage(driver);
                createAccPage = new CreateAccPage(driver);
                createContactPage = new CreateContactPage(driver);
                addedAccOrContPage = new AddedAccOrContPage(driver);
        } catch (Exception e) {
            System.err.println("Ошибка в setUp(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


    @AfterEach()
    @Description("Закрытие браузера")
    public void tearDawn() {
        if (driver != null) {
            driver.quit();
        }
    }
}
