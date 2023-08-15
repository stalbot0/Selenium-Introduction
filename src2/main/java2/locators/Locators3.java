package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/stephentalbot/Docs_Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        absolute xpath starts with a single slash / at the root, to continue to go down the hierarchy continue using /
//        relative xpath starts with double slash //
//        this will give us the sibling DIRECTLY NEXT TO the 1st button (practice) --> (login)
//        this includes the parent to child AND sibling to sibling traversal
//        header --> div --> button1 (practice) --> login (sibling)
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
//        header --> div --> button1 (practice) --> BACK UP TO PARENT div --> button2 (login)
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
    }
}
