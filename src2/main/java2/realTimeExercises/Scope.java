package realTimeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        how many links are in this page?
        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linkCount);
//        how many links are in the footer?
//        create mini driver that only checks the scope of the footer (driver subset)
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        int footerLinkCount = footer.findElements(By.tagName("a")).size();
        System.out.println(footerLinkCount);

    }
}
