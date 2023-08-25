package SeleniumStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class FilterWebTables {
    private static final String rice = "Rice";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys(rice);
//        for every row, the first td is what we need
//        this list gets all the elements on the page
        List<WebElement> groceries = driver.findElements(By.xpath("//tr/td[1]"));
//        this checks the OG list and adds to a new list if the text contains rice
        List<WebElement> allRices = groceries.stream().filter(x -> x.getText().contains(rice)).toList();
//        this should fail because it is comparing 5 to 1
        Assert.assertEquals(groceries.size(), allRices.size());
    }
}
