package assignments;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Assignment5Frames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().defaultContent();
    }
}
