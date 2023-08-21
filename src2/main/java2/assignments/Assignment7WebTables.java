package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7WebTables {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        jsE.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);

//        count rows
        List<WebElement> tableRows = driver.findElements(
                By.cssSelector("div.left-align fieldset table#product tbody tr")
        );
        int rowCount = 0;
        for (WebElement w : tableRows) {
            rowCount++;
        }
        System.out.printf("Row Count: %d\n", rowCount);

//        count columns
        List<WebElement> tableCols = driver.findElements(
                By.cssSelector("div.left-align fieldset table#product tbody tr:nth-child(1) th")
        );
        int colCount = 0;
        for(WebElement w : tableCols) {
            colCount++;
        }
        System.out.printf("Column Count: %d\n", colCount);

//        second row of rahul shetty data
        List<WebElement> secondRowData = driver.findElements(
                By.cssSelector("div.left-align fieldset table#product tbody tr:nth-child(3) td")
        );
        for (int i = 0; i < secondRowData.size(); i++) {
            System.out.printf("column %d: %s\n", i + 1, secondRowData.get(i).getText());
        }
    }
}
