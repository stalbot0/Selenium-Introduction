import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestions {
    public static void main(String[] args) throws InterruptedException {
//        need to be in incognito mode to get to this site
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        handle dropdowns upon typing
        Thread.sleep(1000);
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2500);
        List <WebElement> ops = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement WebE : ops) {
            if (WebE.getText().equalsIgnoreCase("India")) {
                WebE.click();
                break;
            }
        }
    }
}
