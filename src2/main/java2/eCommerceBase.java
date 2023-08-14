import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class eCommerceBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
//        let's add cucumber or broccoli
        String[] vegetablesToTest = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        List<WebElement> vegetableOptions = driver.findElements(By.cssSelector("h4.product-name"));
        int clickCount = 0;

        for (int i = 0; i < vegetableOptions.size(); i++) {
            List<String> newList = Arrays.asList(vegetablesToTest);
            String veggieName = vegetableOptions.get(i).getText();
            String[] separatedVeggieName = veggieName.split("-");
            String formattedVeggieName = separatedVeggieName[0].trim();

            if (newList.contains(formattedVeggieName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                clickCount++;
                if (clickCount == vegetablesToTest.length) {
                    break;
                }
            }

        }
    }
}
