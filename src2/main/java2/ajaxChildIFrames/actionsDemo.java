package ajaxChildIFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        Actions a = new Actions(driver);
        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(signIn).contextClick().build().perform();
    }
}
