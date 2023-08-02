import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
public class Locators2 {
    public static void main(String[] args) {
        String name = "Stephen";
//        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "/Users/stephentalbot/Docs_Drivers/geckodriver");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.edge.driver", "/Users/stephentalbot/Docs_Drivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("Trying to log in for testing that we can log in");
            throw new RuntimeException(e);
        }

//        using the tag name is not always the greatest idea because on a page you could come across
//        multiple tag names of the same kind. for this example, the page we land on only have one <p>
//        element, so we can use this below to compare the expected vs actual values
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(
                driver.findElement(By.tagName("p")).getText(),
                "You are successfully logged in.");
        Assert.assertEquals(
                driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                String.format("Hello %s,", name)
        );
//        another way to find using xpath is by using the text within the tag itself
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    public static String getPassword(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();

        try {
            Thread.sleep(1000); // waiting for something to get in a stable state
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("trying to make it to the forgot your password section");
        }

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
//        once we have the password text, we want to split the string to get the "password" and not the entire string
//        of 'Please use temporary password 'rahulshettyacademy' to Login.'
        String [] passwordArray = passwordText.split("'");
//        0th index --> Please use temporary password
//        1st index --> rahulshettyacademy'
        return passwordArray[1].split("'")[0];
    }
}
