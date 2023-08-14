import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Stephen";
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
//        switch context to alert to get the text in the output and accept it
//        this button only allows us to click ok for the alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("[id='name']")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
//        this button allows us to clock ok OR cancel, the dismiss method will cancel the alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
}
