package ajaxChildIFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
//        Selenium needs to identify the frames before it can be clicked
//        how many iframes are there?
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        WebElement frameWanted = driver.findElement(By.cssSelector("iframe.demo-frame"));
//        switch to the frame using the webelement object created
        driver.switchTo().frame(frameWanted);
//        driver.switchTo().frame(1); // this is using the frames index instead. Not great practice
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
//        initiate the actions object so that we can drag and drop
        Actions hehe = new Actions(driver);
        hehe.dragAndDrop(drag, drop).build().perform();
        driver.switchTo().defaultContent(); // switch back to the original window frame
    }
}
