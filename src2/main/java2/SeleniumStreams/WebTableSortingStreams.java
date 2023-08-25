package SeleniumStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

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

//        get the price of beans
//        click again to put the list back in desc order
        String beans = "Beans";
        List<String> prices = tableLeftColWebElements.stream().
                filter(webElement -> webElement.getText().contains(beans))
//                .map(webElement -> getVeggiePrice(webElement)).toList() // this is the old way of doing it
                .map(WebTableSortingStreams::getPrice).toList();
        prices.forEach(s -> System.out.printf("price of beans: $%s\n", s));

//        get the price of rice (on another page)
        String rice = "Rice";
        List<String> prices2;
        do {
            List<WebElement> tableLeftColWebElements2 = driver.findElements(By.xpath("//tr/td[1]"));
            prices2 = tableLeftColWebElements2.stream().
                    filter(webElement -> webElement.getText().contains(rice))
                    .map(WebTableSortingStreams::getPrice).toList();
            prices2.forEach(s -> System.out.printf("price of rice: $%s\n", s));
//        check to see if there is anything in the list, if not, go to the next page and re-perform the operation
            if (prices2.size() == 0) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (prices2.size() < 1);
    }

    private static String getPrice(WebElement w) {
//        using xpath, this gives us the next sibling
        return w.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
