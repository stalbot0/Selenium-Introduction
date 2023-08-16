package ajaxChildIFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        Actions a = new Actions(driver);
//        .build().perform() to perform all actions in a single step
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
    }
}
