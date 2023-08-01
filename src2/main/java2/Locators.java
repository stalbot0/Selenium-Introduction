import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
//        telling Selenium to wait implicitly for 5 seconds if something does not show up right away.
//        Synchronization issues fixed with this
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
//        inputting username/password into our fields using the targeted selectors and clicking on the sign in btn
        driver.findElement(By.id("inputUsername")).sendKeys("Stephen");
//        OR
//        driver.findElement(By.cssSelector("Input[placeholder=Username]")).sendKeys("Stephen");
        driver.findElement(By.name("inputPassword")).sendKeys("P@ssw0rd");
        driver.findElement(By.className("signInBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//        ^^^ if we do not have a tool such as selectors hub, we can use something like <$('p.error')> in the console
//        itself to print all the elements that have that selector. If it could not be identified it will give you a
//        null response
        driver.findElement(By.linkText("Forgot your password?")).click();
//        introducing Xpath
//        ^^^ if we do not have a tool such as selectors hub, we can use something like
//        <$x('//input[@placeholder="Name"]')> in the console itself to print all the elements that have that selector.
//        If it could not be identified it will give you a null response
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Stephen");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("555-555-5555");
    }
}
