package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3Synchronization {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));

        String username = "rahulshettyacademy";
        String password = "learning";
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement options = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(options);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.btn.btn-info")));
        List<WebElement> productsToAdd = driver.findElements(By.cssSelector("button.btn.btn-info"));
        for (WebElement webElement : productsToAdd) {
            webElement.click();
        }

        driver.findElement(By.partialLinkText("Checkout")).click();
    }
}
