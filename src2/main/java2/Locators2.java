import dev.failsafe.internal.util.Assert;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Stephen");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
//        using the tag name is not always the greatest idea because on a page you could come across
//        multiple tag names of the same kind. for this example, the page we land on only have one <p>
//        element, so we can use this below to compare the expected vs actual values
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }
}
