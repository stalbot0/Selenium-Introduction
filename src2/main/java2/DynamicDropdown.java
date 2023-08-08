import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com");
//        //a[@value='MAA'] - Xpath for chennai
//        //a[@value='BLR'] - Xpath for different city
        driver.findElement(By.id("ct100_mainContent_dd1_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000); // usually use a try catch but just throwing it from the main method
//        by adding the parentheses, we can select the index outside to select which we would like to utilize
//        driver.findElement(By.xpath("(//a[@value='MAA'])2")).click();

//        if we want to do the same thing without indexes, we can use parent/child traversal
        driver.findElement(By.xpath("//div[@id='g1sct100_mainContent_dd1_destinationStation1_CTNR'] //a[@value='MAA']")).click();
    }
}
