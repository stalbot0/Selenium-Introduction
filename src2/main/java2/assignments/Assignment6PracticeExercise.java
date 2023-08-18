package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6PracticeExercise {
    public static void main(String[] args) {
        WebDriver drvr = new ChromeDriver();
        drvr.get("https://rahulshettyacademy.com/AutomationPractice/");
//        select any checkbox and grab the label of the selected checbkox
        drvr.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        String opt1 = drvr.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]")).getText();
        System.out.println(opt1);
//        come to the dropdown and select the same dropdown using the checkbox that was grabbed
        Select dropdowns = new Select(drvr.findElement(By.id("dropdown-class-example")));
        dropdowns.selectByVisibleText(opt1);
//        enter the step 2 into alert box example
        drvr.findElement(By.id("name")).sendKeys(opt1);
//        click alert and verify that the text present is grabbed from step 2 is in the popup
        drvr.findElement(By.id("alertbtn")).click();
        String alertText = drvr.switchTo().alert().getText();
        Assert.assertEquals(alertText, String.format("Hello %s, share this practice page and share your knowledge", opt1));
    }
}
