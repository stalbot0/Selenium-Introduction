package miscTopics;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MaximizeWinDeleteCookie {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://google.com");
//        if we want to delete a single key
//        driver.manage().deleteCookieNamed("sessionKey");

//        output the screenshot as a file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        get the path to our desktop
        String desktopPath = "/Users/stephentalbot/Desktop";
        String screenshotPath = String.format("%s/seleniumScreenshot.png", desktopPath);
//        save the screenshot onto the desktop
        try {
            Path srcPath = screenshotFile.toPath();
            Path destinationPath = Path.of(screenshotPath);
            Files.copy(srcPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
