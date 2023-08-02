import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverIntroduction {
    public static void main(String[] args) {
//        Chrome
//        WebDriver interface that directs what the drivers can do
//        chromedriver.exe -> invokes chrome browser
//        webdriver.chrome.driver -> give the value of the path of where the chrome driver is present
//////// CHROME DRIVER ///////////
//        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.close(); //this closes the browser that was originally opened
//        driver.quit(); //this quits all windows that are open for the automated.
//        If the script has something that tests multiple tabs/windows, use quit. If it is one tab, use close


//        Firefox
//        gecko driver can invoke firefox driver. Sits between code and firefox browser for execution
//        set property like that "webdriver.gecko.driver"
///////     FIREFOX DRIVER ////////
//        System.setProperty("webdriver.gecko.driver", "/Users/stephentalbot/Docs_Drivers/geckodriver");
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.close();


//        Microsoft Edge
        System.setProperty("webdriver.edge.driver", "/Users/stephentalbot/Docs_Drivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
