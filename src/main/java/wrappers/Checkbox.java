package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectCheckbox() {
        WebElement checkbox = driver.findElement(By.xpath(String.format("//td[contains(text(), '%s')]/following-sibling::td/input", label)));
        checkbox.isEnabled();
        checkbox.click();
    }
}
