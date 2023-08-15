package locators;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting for objects to show on the page
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
//        using Thread.sleep allows us to delay the actions after the click. Try/catch is needed bc the thread may be
//        interrupted by another thread and will have to throw an exception
        try {
            Thread.sleep(1000); // waiting for something to get in a stable state
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("trying to make it to the forgot your password section");
        }
//        introducing Xpath
//        ^^^ if we do not have a tool such as selectors hub, we can use something like
//        <$x('//input[@placeholder="Name"]')> in the console itself to print all the elements that have that selector.
//        If it could not be identified it will give you a null response
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Stephen");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("email@gmail.com");
//        we can use the index of the type=text input if we have no unique identifier, as we did below with xpath
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
//        use <input[type='text']:nth-child(3)> as a css selector to access the email as well
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("email2222@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("555-555-5555");
//        we need to make this click wait so that we can have the reset login
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        try {
            Thread.sleep(1000); // waiting for something to get in a stable state
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("trying to make it to the login section");
        }
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Stephen");
//        using regex to check for anything that has a type with 'pass'.... to start
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
    }
}
