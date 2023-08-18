package realTimeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingCalendarUI {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.findElement(By.id("form-field-travel_comp_date")).click();
//        select date of August 23rd
        List<WebElement> august2023dates = driver.findElements(By.className("flatpickr-day"));
        for (WebElement w : august2023dates) {
            if (w.getText().equalsIgnoreCase("23")) {
                w.click();
                break;
            }
        }
    }
}
