package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Textarea {

    WebDriver driver;
    String addressLabel;
    String label;

    public Textarea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeDescription(String text) {
        driver.findElement(By.xpath(String.format("//textarea[@name='%s']", label))).sendKeys(text);
    }
}
