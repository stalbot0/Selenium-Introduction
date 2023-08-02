import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
//        tell selenium to run in the maximize mode
        driver.manage().window().maximize();
        driver.get("https://google.com");
//        go to new webpage while doing automation.
        driver.navigate().to("https://rahulshettyacademy.com");
//        navigate back to google.com
        driver.navigate().back();
        driver.navigate().forward();
    }
}
