package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4HandleWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions a = new Actions(driver);

        WebElement multipleWindowsAnchor = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
        a.scrollToElement(multipleWindowsAnchor).build().perform();
        multipleWindowsAnchor.click();

        WebElement clickHereAnchor = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereAnchor.click();

        Set<String> practiceTabs = driver.getWindowHandles();
        Iterator<String> itr = practiceTabs.iterator();
        String parentTab = itr.next();
        String childTab = itr.next();

        driver.switchTo().window(childTab);
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());

        driver.switchTo().window(parentTab);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
    }
}
