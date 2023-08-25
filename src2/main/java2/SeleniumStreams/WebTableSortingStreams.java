package SeleniumStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class WebTableSortingStreams {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//        click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();
//        put all the web elements into the list
        List<WebElement> tableLeftColWebElements = driver.findElements(By.xpath("//tr/td[1]"));
//        get the text of all web elements into a new list
        List<String> originalTableStrings = tableLeftColWebElements.stream().map(WebElement::getText).toList();
//        sort the list and compare the two
        List<String> sortedTableStrings = originalTableStrings.stream().sorted().toList();
        Assert.assertEquals(sortedTableStrings, originalTableStrings);
    }
}
