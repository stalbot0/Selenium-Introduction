package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2UIExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Bob Smith");
        driver.findElement(By.name("email")).sendKeys("BobSmith@email.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select option = new Select(dropdown);
        option.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("08/13/2023");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
    }
}
