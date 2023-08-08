import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com");
        driver.findElement(By.id("divpaxinfo")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("Trying to select the dropdown for the pax");
            throw new RuntimeException(e);
        }
//        we write a for loop to click it numerous times
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.close();
    }
}
