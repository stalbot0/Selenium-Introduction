import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com");
//        //a[@value='MAA'] - Xpath for chennai
//        //a[@value='BLR'] - Xpath for different city
        driver.findElement(By.id("ct100_mainContent_dd1_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000); // usually use a try catch but just throwing it from the main method
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
    }
}
