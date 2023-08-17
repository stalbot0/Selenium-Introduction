package realTimeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        how many links are in this page?
        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linkCount);

//        how many links are in the footer?
//        create mini driver that only checks the scope of the footer (driver subset)
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        Actions a = new Actions(driver);
        a.scrollToElement(footer).build().perform();
        int footerLinkCount = footer.findElements(By.tagName("a")).size(); // limiting web element scope
        System.out.println(footerLinkCount);

//        links count from only the first column
        WebElement firstColInFooter = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstColInFooterLinkCount = firstColInFooter.findElements(By.tagName("a")).size();
        System.out.println(firstColInFooterLinkCount);

//        click on each link in the column and check if the pages are opening
//        we start from 1 because the first link is not working
        for (int i = 1; i < firstColInFooterLinkCount; i++) {
//            this will open all the tabs in separate tabs
            String clickOnLinkToOpen = Keys.chord(Keys.COMMAND, Keys.RETURN);
            firstColInFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkToOpen);
            Thread.sleep(5000L);
        }

//        opens all the tabs
        Set<String> tabHandles = driver.getWindowHandles();
//        iterates through tabs and prints out the titles for each
        for (String tabHandle : tabHandles) {
            driver.switchTo().window(tabHandle);
            System.out.println(driver.getTitle());
        }
    }
}
