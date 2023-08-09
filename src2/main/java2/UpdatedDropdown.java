import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UpdatedDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com");
        if (!driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) {
//        anything that will match the id with the name that includes SeniorCitizenDiscount
            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        }
//        print the number of checkboxes present in the page
        int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println(checkboxCount); //should give us 6 but spicejet.com is a hoax

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
