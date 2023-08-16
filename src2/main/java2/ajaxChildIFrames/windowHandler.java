package ajaxChildIFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class windowHandler {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
//        this will send us to the second tab that is opened once clicked
        driver.findElement(By.cssSelector("a.blinkingText")).click();
//        the driver only invokes the original page, so we have to pass the new tab explicitly to selenium
        Set<String> openTabs = driver.getWindowHandles(); //[parent, child]
        Iterator<String> it = openTabs.iterator();
        String parentTab = it.next();
        String childTab = it.next();
        driver.switchTo().window(childTab);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.im-para.red")));
//        we want to extract the email ID (debugger with expression evaluated)
        String email = driver.findElement(By.cssSelector("p.im-para.red")).getText()
                    .split("at")[1].trim().split(" ")[0];
//        switch back over to the parent tab
        driver.switchTo().window(parentTab);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
