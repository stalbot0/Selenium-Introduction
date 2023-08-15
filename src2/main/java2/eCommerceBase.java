import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class eCommerceBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        Thread.sleep(3000); //got rid of this because we now wait implicitly
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //implicit wait applied globally
//        we commented out the implicit wait because now it is not glocal as we have applied the explicit wait
//        for the two steps that we needed to wait for
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5)); // explicit wait for this object max 5 sec
//        let's add cucumber or broccoli
        String[] vegetablesToTest = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        addItems(driver, vegetablesToTest);
        driver.findElement(By.cssSelector("a.cart-icon img[alt='Cart']")).click();
//        proceed to checkout
        driver.findElement(By.cssSelector("div.action-block button")).click();
//        we need to wait for the page to load here
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
//        explicitly wait for the coupon to be applied
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
//        then print out the message for the coupon
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, String[] vegetablesToTest) {
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
