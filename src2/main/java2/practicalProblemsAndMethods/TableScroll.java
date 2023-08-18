package practicalProblemsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableScroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        apply scroll to the webpage
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);
//        apply scroll to the table now
        js.executeScript("document.querySelector(\"div.tableFixHead\").scrollTop=5000;");
//        div.tableFixHead table#product tbody tr td:nth-child(4)
        List<WebElement> tableAmounts = driver.findElements(
                By.cssSelector("div.tableFixHead table#product tbody tr td:nth-child(4)")
        );

        int sumOfTableAmounts = 0;

        for (WebElement tableAmount : tableAmounts) {
            sumOfTableAmounts += Integer.parseInt(tableAmount.getText());
        }

        System.out.println(sumOfTableAmounts);
    }
}
